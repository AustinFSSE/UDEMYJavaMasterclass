package dev.alm;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private static int customerId = 100;

    private final String name;
    private int id;
    private final List <BankAccount> accounts = new ArrayList <BankAccount>();

    public BankCustomer(String name, double checkingAmount, double savingsAmount) {
        this.name = name;
        this.id = customerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVING, savingsAmount));
    }

    public String getName() {
        return name;
    }

    public List <BankAccount> getAccounts() {
        return new ArrayList <>(accounts);
    }

    @Override
    public String toString() {
        String [] accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings, i -> accounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(name, customerId, String.join("\n\t", accountStrings));
    }
}
