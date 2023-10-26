package com.example.baitap.service.customer;

import com.example.baitap.model.Customer;
import com.example.baitap.model.Deposit;
import com.example.baitap.model.Transfer;
import com.example.baitap.model.Withdraw;
import com.example.baitap.service.Transfer.TransferService;
import com.example.baitap.service.deposit.DepositService;
import com.example.baitap.service.withdraw.WithdrawService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerService implements ICustomerService{
    private DepositService depositService = new DepositService();
    private WithdrawService withdrawService = new WithdrawService();
    private TransferService transferService = new TransferService();
    private static final List<Customer> customers = new ArrayList<>();
    private static Long id = 1L;

    static {
        customers.add(new Customer(id++, "NVA", "nva@co.cc", "2345", "28 Nguyễn Tri Phương", BigDecimal.ZERO, false));
    }

    @Override
    public List<Customer> findAll(boolean deleted) {
        return customers.stream().filter(customer -> customer.getDeleted() == deleted).collect(Collectors.toList());
    }

    @Override
    public Customer findById(Long id) {
        for (Customer c : customers){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public void create(Customer customer) {
        customer.setId(id++);
        customer.setBalance(BigDecimal.ZERO);
        customer.setDeleted(false);
        customers.add(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        for (Customer c : customers){
            if (c.getId() == id){
                c.setFullName(customer.getFullName());
                c.setEmail(customer.getEmail());
                c.setPhone(customer.getPhone());
                c.setAddress(customer.getAddress());
            }
        }
    }

    @Override
    public void removeById(Long id) {
        for (Customer c : customers){
            if (c.getId() == id){
                c.setDeleted(true);
                break;
            }
        }
    }

    @Override
    public void deposit(Deposit deposit) {
        Customer customer = deposit.getCustomer();
        BigDecimal currentBalance = customer.getBalance();
        BigDecimal transactionAmount = deposit.getTransactionAmount();
        BigDecimal newBalance = currentBalance.add(transactionAmount);
        customer.setBalance(newBalance);

        update(customer.getId(), customer);
        depositService.create(deposit);
    }

    @Override
    public void withdraw(Withdraw withdraw) {
        Customer customer = withdraw.getCustomer();
        BigDecimal currentBalance = customer.getBalance();
        BigDecimal transactionAmount = withdraw.getTransactionAmount();
        BigDecimal newBalance = currentBalance.subtract(transactionAmount);
        customer.setBalance(newBalance);

        update(customer.getId(), customer);
        withdrawService.create(withdraw);
    }

    @Override
    public void transfer(Transfer transfer) {
        Customer sender = transfer.getSender();
        Customer recipient = transfer.getRecipient();
        BigDecimal transferAmount = transfer.getTransferAmount();
        Long fees = 10L;
        BigDecimal feesAmount = transferAmount.multiply(BigDecimal.valueOf(fees)).divide(BigDecimal.valueOf(100));
        BigDecimal transactionAmount = transferAmount.add(feesAmount);
        BigDecimal senderBalance = sender.getBalance();
        BigDecimal newSenderBalance = senderBalance.subtract(transactionAmount);
        sender.setBalance(newSenderBalance);
        BigDecimal recipientBalance = recipient.getBalance();
        BigDecimal newRecipientBalance = recipientBalance.add(transferAmount);
        recipient.setBalance(newRecipientBalance);

        update(sender.getId(), sender);
        update(recipient.getId(), recipient);

        transfer.setFees(fees);
        transfer.setFeesAmount(feesAmount);
        transfer.setTransactionAmount(transactionAmount);
        transferService.create(transfer);
    }

    @Override
    public List<Customer> findAllWithoutId(Long id) {
        return customers.stream().filter(customer -> !Objects.equals(customer.getId(), id)).collect(Collectors.toList());
    }
}
