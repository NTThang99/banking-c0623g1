package com.example.baitap.service.withdraw;

import com.example.baitap.model.Deposit;
import com.example.baitap.model.Withdraw;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WithdrawService implements IWithdrawService{
    private static final List<Withdraw> withdraws = new ArrayList<>();
    private static Long id = 1L;
    @Override
    public List<Withdraw> findAll(boolean deleted) {
        return withdraws;
    }

    @Override
    public Withdraw findById(Long id) {
        return null;
    }

    @Override
    public void create(Withdraw withdraw) {
        withdraw.setId(id++);
        withdraw.setDateWithdrawal(LocalDateTime.now());
        withdraws.add(withdraw);
    }

    @Override
    public void update(Long aLong, Withdraw withdraw) {

    }

    @Override
    public void removeById(Long id) {

    }
}
