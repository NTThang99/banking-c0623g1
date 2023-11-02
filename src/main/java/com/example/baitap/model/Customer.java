package com.example.baitap.model;

import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;


@Entity
@Table(name = "customers")
public class Customer implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname", nullable = false)

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String address;

    @Column(columnDefinition = "DECIMAL(12,0) default 0 ", updatable = false)
    private BigDecimal balance;

    @Column(columnDefinition = "TINYINT(1) default 0", updatable = false)
    private Boolean deleted;

    public Customer() {
    }

    public Customer(long id, String fullName, String email, String phone, String address, BigDecimal balance, boolean deleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Customer customer = (Customer) o;
        String fullName = customer.fullName;
        String email = customer.email;
        String phone = customer.phone;
        String address = customer.address;


        if (fullName.isEmpty() || fullName.trim() == "") {

            errors.rejectValue("fullName", "fullName.empty");
        }

        if (email.isEmpty() || email.trim() == "") {

            errors.rejectValue("email", "email.empty");
        } else if (!email.matches("[A-Za-z0-9+_.-]+@(.+)")) {

            errors.rejectValue("email", "email.pattern");
        }

        if (phone.isEmpty()) {
            errors.rejectValue("phone", "phone.empty");

        } else if (!phone.matches("\\d+")) {
            errors.rejectValue("phone", "phone.notNumeric");

        } else if (phone.length() != 10) {
            errors.rejectValue("phone", "phone.lenghth");

        } else if (phone.matches("^0\\\\d{9}$")) {
            errors.rejectValue("phone", "phone.number");
        }

        if (address.isEmpty() || address.trim() == "") {

            errors.rejectValue("address", "address.empty");
        }

    }
}

