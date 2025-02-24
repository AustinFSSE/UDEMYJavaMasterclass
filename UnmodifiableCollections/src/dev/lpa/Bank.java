package dev.lpa;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public final int routingNumber;
    private long lastTransactionId;
    private Map <String, BankCustomer> customers;

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        customers = new HashMap<>();
    }

    BankCustomer getCustomer(String customerId) {
        BankCustomer customer = customers.get(customerId);
        return customer;
    }
    void addCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit) {
            BankCustomer customer = new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
            customers.put(customer.getCustomerId(), customer);
    }
    public boolean doTransaction(String customerId, BankAccount.AccountType type, double amount ) {
        BankCustomer customer = getCustomer(customerId);
        if (customer != null) {
            BankAccount account = customer.getAccountType(type);
            if (account != null) {
                if (amount < 0 && (account.getAmount() - amount) < 0) {
                    return false;
                } else {
                    account.commitTransaction(routingNumber, lastTransactionId++, customerId, amount);
                    return true;
                }
            }
        } else {
            System.out.println("Customer " + customerId + " not found");
        }
        return false;
    }
}
