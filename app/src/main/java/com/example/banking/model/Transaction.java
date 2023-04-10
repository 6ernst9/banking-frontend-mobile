package com.example.banking.model;
import java.time.LocalDateTime;

public class Transaction {
    private long id;
    private Long senderAccount;
    private Long receiverAccount;
    private String currency;
    private LocalDateTime timeOfTransaction;
    private double amount;

    public Transaction(Long id, Long sender, Long receiver, double amount, String currency) {
        this.id = id;
        timeOfTransaction = LocalDateTime.now();
        this.senderAccount = sender;
        this.currency = currency;
        this.receiverAccount = receiver;
        this.amount = amount;
    }
    public Transaction(Long sender, Long receiver, double amount, String currency) {
        this.senderAccount = sender;
        this.currency = currency;
        timeOfTransaction = LocalDateTime.now();
        this.receiverAccount = receiver;
        this.amount = amount;
    }
    public Transaction(Long sender, double amount, String currency) {
        this.senderAccount = sender;
        this.currency = currency;
        timeOfTransaction = LocalDateTime.now();
        this.receiverAccount = -1L;
        this.amount = amount;
    }
    public Transaction(double amount, Long receiver, String currency) {
        this.senderAccount = -1L;
        this.currency = currency;
        timeOfTransaction = LocalDateTime.now();
        this.receiverAccount = receiver;
        this.amount = amount;
    }
    public Transaction(Long sender, Long receiver, double amount) {
        this.senderAccount = sender;
        timeOfTransaction = LocalDateTime.now();
        this.receiverAccount = receiver;
        this.amount = amount;
    }

    public Transaction() {
        timeOfTransaction = LocalDateTime.now();
    }

    public LocalDateTime getTimeOfTransaction() {
        return timeOfTransaction;
    }
    public double getAmount() {
        return amount;
    }
    public String getCurrency() {
        return currency;
    }

    public Long getReceiverAccount() {
        return receiverAccount;
    }
    public Long getSenderAccount() {
        return senderAccount;
    }
    public long getId() {
        return id;
    }
}
