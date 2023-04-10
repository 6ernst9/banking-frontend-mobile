package com.example.banking.model;

import java.time.LocalDate;
import java.util.Random;

public class Account {
    private Long accountId;
    private Long accountNumber;
    private int accountPin;
    private int accountCvv;
    private LocalDate expDate;
    private Long personId;
    private String currency;
    private double balance;

    public Account(Long personId, Long accountId, String currency, int accountPin) {
        this.personId = personId;
        this.accountId = accountId;
        this.currency = currency;
        this.accountPin = accountPin;
        this.accountCvv = generateCvv();
        expDate = LocalDate.now().plusMonths(60);
        accountNumber = generateAccountNumber();
        this.balance = Currencies.getCurrency(currency).convertFrom(100, Currencies.getCurrency("EUR"));
    }
    public Account(Long personId, String currency, int accountPin) {
        this.personId = personId;
        this.currency = currency;
        this.accountPin = accountPin;
        this.accountCvv = generateCvv();
        accountNumber = generateAccountNumber();
        expDate = LocalDate.now().plusMonths(60);
        this.balance = Currencies.getCurrency(currency).convertFrom(100, Currencies.getCurrency("EUR"));
    }

    public Account() {

    }

    public int getAccountCvv() {
        return accountCvv;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }
    private static Long generateAccountNumber(){
        Random random = new Random();
        int isVisa = random.nextInt(2);
        if(isVisa==0){
            //return random.nextLong(5600000000000000L-5000000000000000L) + 5000000000000000L;
        }
        else{
            //return random.nextLong(5000000000000000L - 4000000000000000L) + 4000000000000000L;
        }
        return 0l; //transient
    }
    private static int generateCvv(){
        Random random = new Random();
        return random.nextInt(999-100) + 100;
    }
    public Long getPersonId() {
        return personId;
    }
    public Long getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }
}
