package java_basics.fifth_topic;

public class RefundTransactionPage extends TransactionPage {
    public RefundTransactionPage(String name, double price) {
        super(name, price);
    }

    public void transaction() {
        System.out.println("This is a Refund Transaction with a name of " + getName()
                + " and $" + getPrice() + ".");
    }
}
