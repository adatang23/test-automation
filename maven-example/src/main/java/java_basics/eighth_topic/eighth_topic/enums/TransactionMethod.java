package java_basics.eighth_topic.eighth_topic.enums;

public enum TransactionMethod {
    BANKTRANSFER_METHOD("Bank Transfer method"),
    CREDITCARD_METHOD("Credit Card method"),
    DEBITCARD_METHOD("Debit Card method"),
    CASH_METHOD("Cash method"),
    DIGITALWALLET_METHOD("Digital Wallet method"),
    MONEYORDER_METHOD("Money Order method"),
    CHECK_METHOD("Check method");

    private final String type;


    TransactionMethod(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    @Override
    public String toString() {
        return "This is " + type;
    }

}


class Transaction {
    private TransactionMethod transactionMethod;
    private double price;

    Transaction(TransactionMethod transactionMethod, double price) {
        this.transactionMethod = transactionMethod;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double applyDiscount(double rate) {
        return price * rate;
    }

    @Override
    public String toString() {
        return transactionMethod.toString() + ", the original price is $" + price;
    }


    public void tellTransactionResult(){
        switch(transactionMethod) {
            case BANKTRANSFER_METHOD:
                System.out.println(toString() + "\nThe price is $" + price);
                break;

            case CREDITCARD_METHOD:
                System.out.println(toString() + "\nThe price is $" + applyDiscount(0.97));
                break;

            case DEBITCARD_METHOD:
                System.out.println(toString() + "\nThe price is $" + applyDiscount(0.99));
                break;

            case CASH_METHOD:
                System.out.println(toString() + "\nThe price is $" + price);
                break;

            case DIGITALWALLET_METHOD:
                System.out.println(toString() + "\nThe price is $" + applyDiscount(0.98));
                break;

            case MONEYORDER_METHOD:
                System.out.println(toString() + "\nThe price is $" + price);
                break;

            case CHECK_METHOD:
                System.out.println(toString() + "\nThe price is $" + price);
                break;
        }
    }
}
