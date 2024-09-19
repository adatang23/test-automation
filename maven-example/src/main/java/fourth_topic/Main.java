package fourth_topic;
import fourth_topic.exceptions.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        PaymentSystems systems = new PaymentSystems();

        /**
         * test the log levels
         */
        systems.Log4j2Test();


        /**
         * Handle exceptions in try-catch way
         * Test getPaymentById() method, PaymentIdNotFoundException
         */
        try {
            systems.getPaymentById("CreditCardPay");
        } catch (InvalidPaymentIdException e) {
            e.printStackTrace();
        } catch (PaymentIdNotFoundException e) {
            e.printStackTrace();
        }


        /**
         * Handle exceptions in try-catch way
         * Test getPaymentById() method, InvalidPaymentIdException
         */
        try {
            systems.getPaymentById("1 2 3 4 5");
        } catch (InvalidPaymentIdException e) {
            e.printStackTrace();
        } catch (PaymentIdNotFoundException e) {
            e.printStackTrace();
        }


        /**
         * Handle Exceptions in try-catch-finally way
         * Test transaction(Object obj), PaymentNotExistedException
         */
        try {
            PaymentSystems.CreditCard pay = null;
            systems.transaction(pay);
        } catch (PaymentNotExistedException e) {
            e.printStackTrace();
        } catch (InvalidPaymentMethodException e) {
            e.printStackTrace();
        } catch (InvalidPaymentAmountException e) {
            e.printStackTrace();
        }


        /**
         * Handle Exceptions in try-catch-finally way
         * Test transaction(Object obj), InvalidPaymentMethodException
         */
        try {
            PaymentSystems.InvalidMethod invalidMethod = new PaymentSystems.InvalidMethod(1000.0);
            systems.transaction(invalidMethod);
        } catch (PaymentNotExistedException e) {
            e.printStackTrace();
        } catch (InvalidPaymentMethodException e) {
            e.printStackTrace();
        } catch (InvalidPaymentAmountException e) {
            e.printStackTrace();
        }


        /**
         * Handle Exceptions in try-catch-finally way
         * Test transaction(Object obj), InvalidPaymentAmountException
         */
        try {
            PaymentSystems.CreditCard creditCardPay = new PaymentSystems.CreditCard(-100);
            systems.transaction(creditCardPay);
        } catch (PaymentNotExistedException e) {
            e.printStackTrace();
        } catch (InvalidPaymentMethodException e) {
            e.printStackTrace();
        } catch (InvalidPaymentAmountException e) {
            e.printStackTrace();
        }


        /**
         * Handle Exceptions in try-with-resource way
         * Test readPaymentFile(String filename), IOException
         */
        try {
            systems.readPaymentFile("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}