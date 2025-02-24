package dev.lpa;


import dev.dto.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    public enum AccountType { CHECKING, SAVING, OTHER}
    private final AccountType type;
    private double amount;
    private final Map <Long, Transaction> transactions = new LinkedHashMap <>();

    BankAccount(AccountType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public AccountType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Map <Long, Transaction> getTransactions() {
        return Map.copyOf(transactions);
    }
    void commitTransaction(int routingNumber, long transactionId, String customerId, double amount) {
        this.amount += amount;
        transactions.put(transactionId, new Transaction(routingNumber, transactionId, Integer.parseInt(customerId), amount));
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(type, amount);
    }
}
