package dev.lpa;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private static int customerId = 100;

    private final String name;
    private int id;
    private final List <BankAccount> accounts = new ArrayList <BankAccount>();

    BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.id = customerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVING, savingsAmount));
    }

    public String getName() {
        return name;
    }

    public List <BankAccount> getAccounts() {
        return List.copyOf(accounts);
    }

    public BankAccount getAccountType(BankAccount.AccountType type) {
        for ( var account : accounts) {
            if (account.getType() == type) {
                return account;
            }
        }
        return null;
    }

    public String getCustomerId() {

        return String.valueOf(customerId);
    }
    @Override
    public String toString() {
        String [] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId, String.join("\n\t", accountStrings));
    }
}
