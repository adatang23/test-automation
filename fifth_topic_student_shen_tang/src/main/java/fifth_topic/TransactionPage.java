package fifth_topic;

public abstract class TransactionPage extends AbstractPage {
    private String name;
    private double price;

    public TransactionPage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void transaction();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
