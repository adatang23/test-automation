package second_topic;

import java.util.Arrays;
import java.util.Objects;

public class Transaction {
    private String transactionId;
    private double price;

    public Transaction(String transactionId, double price) {
        this.transactionId = transactionId;
        this.price = price;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "The transaction with an ID of " + transactionId
                + " has a price of $" + price + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            Transaction transaction = (Transaction) obj;
            return (transaction.getTransactionId().equals(this.getTransactionId())
                    && transaction.price == this.price);
        }
    }
}
