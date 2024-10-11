package java_basics.second_topic;

import java.util.Objects;

public class SaleTransaction extends Transaction {
    private String productName;

    public SaleTransaction(String transactionId, double price, String productName) {
        super(transactionId, price);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "The sale transaction with an ID of " + getTransactionId()
                + " has a purchase of " + productName
                + " with a price of $" + getPrice() + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransactionId(), getPrice(), productName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            SaleTransaction saleTransaction = (SaleTransaction) obj;
            return (saleTransaction.getTransactionId().equals(this.getTransactionId())
                    && saleTransaction.getPrice() == this.getPrice()
                    && saleTransaction.productName.equals(this.productName));
        }
    }
}
