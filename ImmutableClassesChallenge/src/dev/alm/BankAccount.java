package dev.alm;



public class BankAccount {
    public enum AccountType { CHECKING, SAVING, OTHER}
    private final AccountType type;
    private final double amount;

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

    @Override
    public String toString() {
        return "%s $%.2f".formatted(type, amount);
    }
}
