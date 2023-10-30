package com.example.baitap.repository;

import com.example.baitap.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findCustomerByDeleted(Boolean deleted);
}
