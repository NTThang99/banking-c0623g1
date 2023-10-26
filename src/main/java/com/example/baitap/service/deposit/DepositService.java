package com.example.baitap.service.deposit;

import com.example.baitap.model.Customer;
import com.example.baitap.model.Deposit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepositService implements IDepositService{
    private static final List<Deposit> deposits = new ArrayList<>();
    private static Long id = 1L;
    @Override
    public List<Deposit> findAll(boolean deleted) {
        return deposits;
    }

    @Override
    public Deposit findById(Long id) {
        return null;
    }

    @Override
    public void create(Deposit deposit) {
        deposit.setId(id++);
        deposit.setDateDeposit(LocalDateTime.now());
        deposits.add(deposit);
    }

    @Override
    public void update(Long aLong, Deposit deposit) {

    }

    @Override
    public void removeById(Long id) {

    }
}
