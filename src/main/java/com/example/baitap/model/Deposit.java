package com.example.baitap.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Deposit {
    private Long id;
    private Customer customer;
    private BigDecimal transactionAmount;
    private LocalDateTime dateDeposit;

    public Deposit() {
    }

    public Deposit(Long id, Customer customer, BigDecimal transactionAmount, LocalDateTime dateDeposit) {
        this.id = id;
        this.customer = customer;
        this.transactionAmount = transactionAmount;
        this.dateDeposit = dateDeposit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getDateDeposit() {
        return dateDeposit;
    }

    public void setDateDeposit(LocalDateTime dateDeposit) {
        this.dateDeposit = dateDeposit;
    }

    public String createDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return dateDeposit.format(formatter);
    }
}
