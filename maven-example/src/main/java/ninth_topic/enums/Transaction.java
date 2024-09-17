package ninth_topic.enums;

public class Transaction {
    private TransactionMethod transactionMethod;
    private double price;



    public Transaction(TransactionMethod transactionMethod, double price) {
        this.transactionMethod = transactionMethod;
        this.price = price;
    }

    public String getTransactionMethod() { return transactionMethod.getType(); }

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