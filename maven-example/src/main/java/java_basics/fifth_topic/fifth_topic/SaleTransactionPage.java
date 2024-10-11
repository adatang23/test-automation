package java_basics.fifth_topic.fifth_topic;

public class SaleTransactionPage extends TransactionPage {
    public SaleTransactionPage(String name, double price) {
        super(name, price);
    }
    public void transaction() {
        System.out.println("This is a Sale Transaction with a name of " + getName()
                + " and $" + getPrice() + ".");
    }
}
