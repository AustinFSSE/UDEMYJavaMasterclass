package dev.dto;

public class Transaction {
    private int routingNumber, customerId;
    private long transactionId;
    private double transactionAmount;

    public Transaction(int routingNumber, long transactionId, int customerId, double transactionAmount) {
        this.routingNumber = routingNumber;
        this.transactionAmount = transactionAmount;
        this.transactionId = transactionId;
        this.customerId = customerId;
    }

    public int getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(int routingNumber) {
        this.routingNumber = routingNumber;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "%015d:%020d:%015d:%012.2f".formatted(routingNumber, customerId,
                transactionId, transactionAmount);
    }
}
