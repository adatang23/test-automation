package ninth_topic.enums;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;

public class TransactionList {
    public TransactionMethod transactionMethod;
    private Transaction transaction10 = new Transaction(TransactionMethod.BANKTRANSFER_METHOD, 100.0);
    private final double PI = 3.14159;
    private String transactionNameNull;
    protected List<Transaction> transactionList = new ArrayList<>();

    // Collection stream with terminal and non-terminal operations
    public static Map<String, Double> groupTransactionPriceByMethods(List<Transaction> transactionList) {
        Map<String, Double> res = transactionList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Transaction::getTransactionMethod,
                        Collectors.summingDouble(Transaction::getPrice)));
        return res;
    }

    // Collection stream with terminal and non-terminal operations
    public static Map<Double, List<Transaction>> groupTransactionByPrice(List<Transaction> transactionList) {
        Map<Double, List<Transaction>> ans = transactionList.parallelStream()
                .collect(Collectors.groupingByConcurrent(x -> Math.floor(x.getPrice()/100.0), Collectors.toList()));
        return ans;
    }

    public String getTransactionNameNull() {
        try {
            return transactionNameNull;
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printMessage(String message) {
        System.out.println("Invoke printMessage() by invoke() and message: " + message);
    }

    //2. Using reflection extract information(modifiers, return types, parameters, etc)
    // about fields, constructors, and methods. Create object and call method using only reflection.

    public static void main(String...args) {
        try {
            // call methods by parameters
            Class<?> c = Class.forName(args[0]);
            Field f = c.getField(args[1]);
            System.out.format("Type: %s%n", f.getType());
            System.out.format("GenericType: %s%n", f.getGenericType());
            System.out.println("");

            // invoke methods by parameters using invoke();
            TransactionList newTransactionList = new TransactionList();
            Class<?> classObj = newTransactionList.getClass();
            Method printMessage = classObj.getDeclaredMethod("printMessage", String.class);
            printMessage.invoke(newTransactionList, "hello");

            // Using Reflection extract information about Fields
            System.out.println("Using reflection extract information about fields:");
            Field[] flds = TransactionList.class.getDeclaredFields();
            for (Field field : flds) {
                String name = field.getName();
                Object type = field.getType();
                Object genericType = field.getGenericType();
                int mod = field.getModifiers();
                System.out.println("Name: " + name + "\n"
                        + "Type: " + String.valueOf(type) + "\n"
                        + "Generic Type: " + String.valueOf(genericType) + "\n"
                        + "Modifier: " + Modifier.toString(mod) + "\n");
            }
            System.out.println("");

            // Using Reflection extract information about Methods
            System.out.println("Using reflection extract information about methods:");
            Method[] methods = TransactionList.class.getDeclaredMethods();
            for (Method method: methods) {
                String name = method.getName();
                Object type = method.getReturnType();
                Object genericType = method.getGenericReturnType();
                Object exceptionType = method.getExceptionTypes();
                Object genericExceptionType = method.getGenericExceptionTypes();
                int mod = method.getModifiers();
                System.out.println("Name: " + name + "\n"
                        + "Type: " + String.valueOf(type) + "\n"
                        + "Generic Type: " + String.valueOf(genericType) + "\n"
                        + "Exception Type: " + String.valueOf(exceptionType) + "\n"
                        + "Generic Exception Type: " + String.valueOf(genericExceptionType) + "\n");
            }
            System.out.println("");

            // Using Reflection extract information about Constructors


        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}