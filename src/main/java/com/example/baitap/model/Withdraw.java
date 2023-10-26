package com.example.baitap.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Withdraw {
    private Long id;
    private Customer customer;
    private BigDecimal transactionAmount;
    private LocalDateTime dateWithdrawal;

    public Withdraw() {
    }

    public Withdraw(Long id, Customer customer, BigDecimal transactionAmount, LocalDateTime dateWithdrawal) {
        this.id = id;
        this.customer = customer;
        this.transactionAmount = transactionAmount;
        this.dateWithdrawal = dateWithdrawal;
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

    public LocalDateTime getDateWithdrawal() {
        return dateWithdrawal;
    }

    public void setDateWithdrawal(LocalDateTime dateWithdrawal) {
        this.dateWithdrawal = dateWithdrawal;
    }

    public String createDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return dateWithdrawal.format(formatter);
    }
}
