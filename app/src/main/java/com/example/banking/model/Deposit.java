package com.example.banking.model;

public class Deposit {
    private final double amount;
    private final Long accountId;
    private final String currency;

    public Deposit( Long accountId, double amount,String currency) {
        this.amount = amount;
        this.accountId = accountId;
        this.currency = currency;
    }
    public double getAmount() {
        return amount;
    }
    public Long getAccountId() {
        return accountId;
    }

    public String getCurrency() {
        return currency;
    }
}
