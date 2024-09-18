package ninth_topic.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;

public class Transaction {
    public TransactionMethod transactionMethod;
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

    public static void main(String...args) {
        try {
            // call methods by parameters
            Class<?> c = Class.forName(args[0]);
            Field f = c.getField(args[1]);
            System.out.format("Type: %s%n", f.getType());
            System.out.format("GenericType: %s%n", f.getGenericType());
            System.out.println("");

            // Using Reflection extract information about Constructors
            // invoke methods by a specific declaration
            System.out.println("Using reflection extract information about constructors:");
            Constructor[] allConstructors = Transaction.class.getDeclaredConstructors();
            for (Constructor constructor : allConstructors) {
                Class<?>[] pType = constructor.getParameterTypes();
                Type[] gpType = constructor.getGenericParameterTypes();
                System.out.println("Parameter Types: " + Arrays.stream(pType).toList() + "\n"
                        + "Generic Parameter Types: " + Arrays.stream(gpType).toList() + "\n");
            }

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        }
    }
}