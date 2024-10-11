package java_basics.second_topic.second_topic;

import java.util.Objects;

public class RefundTransaction extends Transaction {
    private String customerId;

    public RefundTransaction(String transactionId, double price, String customerId) {
        super(transactionId, price);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public String toString() {
        return "The refund transaction with an ID of " + getTransactionId()
                + " transferred $" + getPrice()
                + " to the customer with an ID of " + customerId + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionId(), getPrice(), customerId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            RefundTransaction refundTransaction = (RefundTransaction) obj;
            return (refundTransaction.getTransactionId().equals(this.getTransactionId())
                    && refundTransaction.getPrice() == this.getPrice()
                    && refundTransaction.customerId.equals(this.customerId));
        }
    }
}
