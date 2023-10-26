package com.example.baitap.service.Transfer;

import com.example.baitap.model.Customer;
import com.example.baitap.model.Transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferService implements ITransferService{
    private static final List<Transfer> transfers = new ArrayList<>();
    private static Long id = 1L;

    @Override
    public List<Transfer> findAll() {
        return transfers;
    }

    @Override
    public List<Transfer> findAll(boolean deleted) {
        return null;
    }

    @Override
    public Transfer findById(Long id) {
        return null;
    }

    @Override
    public void create(Transfer transfer) {
        transfer.setId(id++);
        transfer.setDateTransfer(LocalDateTime.now());
        transfers.add(transfer);
    }

    @Override
    public void update(Long id, Transfer transfer) {

    }

    @Override
    public void removeById(Long aLong) {

    }

//    public void createHistory(String name, String recipientName, BigDecimal transferAmount){
//        Transfer transfer = new Transfer();
//        transfer.setId(id++);
//        transfer.setSenderName(name);
//        transfer.setRecipientName(recipientName);
//        transfer.setTransferAmount(transferAmount);
//        transfer.setDateTransfer(new Date());
//        transfers.add(transfer);
//    }
}
