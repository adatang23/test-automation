package java_basics.second_topic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /**
         * Test Transaction, SaleTransaction, RefundTransaction, User, Customer, and Admin
         */
        System.out.println("Results of Transaction, SaleTransaction, and RefundTransaction:");

        /**
         * Create Transaction objects and print the results of the overridden toString() methods
         */
        Transaction saleTransaction = new SaleTransaction("SaleTrans25",
                1100, "Desktop");
        Transaction refundTransaction = new RefundTransaction("RefundTrans19",
                30, "JamesSmith25");
        System.out.println(saleTransaction.toString());
        System.out.println(refundTransaction.toString());

        /**
         * Create a new Transaction object and compare the objects
         * by the overridden hashCode() and equals() methods
         */
        Transaction newSaleTransaction = new SaleTransaction("SaleTrans25",
                1100, "Desktop");
        System.out.println("Are the hash code of saleTransaction and newSaleTransaction the same? "
                + (saleTransaction.hashCode() == newSaleTransaction.hashCode()));
        System.out.println("Are saleTransaction and newSaleTransaction the same object? "
                + (saleTransaction.equals(newSaleTransaction)));

        /**
         * Create another new Transaction object and compare the objects
         * by the overridden hashCode() and equals() methods
         */
        Transaction newRefundTransaction = new RefundTransaction("RefundTrans19",
                30, "JamesSmith25");
        System.out.println("Are the hash code of refundTransaction and newRefundTransaction the same? "
                + (refundTransaction.hashCode() == newRefundTransaction.hashCode()));
        System.out.println("Are refundTransaction and newRefundTransaction the same object? "
                + (refundTransaction.equals(newRefundTransaction)));
        System.out.println("");


        /**
         * Test User, Customer, and Admin
         */
        System.out.println("Results of User, Customer, and Admin:");

        /**
         * Create User objects and print the results of the overridden toString() methods
         */
        User customer = new Customer("JamesSmith25", "123456",
                5000, 800);
        User admin = new Admin("MichaelBrown35", "654321",
                new String[] {"SaleTrans25", "RefundTrans19"},
                new String[] {"JamesSmith25", "LindaJohnson19"});
        System.out.println(customer.toString());
        System.out.println(admin.toString());

        /**
         * Create a new User object and compare the objects
         * by the overridden hashCode() and equals() methods
         */
        User newCustomer = new Customer("JamesSmith25", "123456",
                5000, 800);
        System.out.println("Are the hash code of customer and newCustomer the same? "
                + (customer.hashCode() == newCustomer.hashCode()));
        System.out.println("Are customer and newCustomer the same object? "
                + (customer.equals(newCustomer)));

        /**
         * Create another User object and compare the objects
         * by the overridden hashCode() and equals() method
         */
        User newAdmin = new Admin("MichaelBrown35", "654321",
                new String[] {"SaleTrans25", "RefundTrans19"},
                new String[] {"JamesSmith25", "LindaJohnson19"});
        System.out.println("Are the hash code of admin and newAdmin the same? "
                + (admin.hashCode() == newAdmin.hashCode()));
        System.out.println("Are admin and newAdmin the same object? "
                + (admin.equals(newAdmin)));

        /**
         * Print the Admin's transaction list and user list.
         */
        System.out.println(Arrays.toString(((Admin) admin).getTransactionList()));
        System.out.println(Arrays.toString(((Admin) admin).getUserList()));
        System.out.println("");

        /**
         * Print the Customer's balance and total purchase.
         */
        System.out.println("Results of Customer and Transaction:");
        System.out.println("The customer's balance is: $"
                + ((Customer) customer).getBalance());
        System.out.println("The customer's total purchase is: $"
                + ((Customer) customer).getTotalPurchase());

        /**
         * The customer get a sale transaction and print the customer's balance and total purchase
         */
        ((Customer) customer).getTransaction((SaleTransaction) saleTransaction);
        System.out.println("After the sale transaction of " + ((SaleTransaction) saleTransaction).getTransactionId()
                + ", the customer's current balance is: $" + ((Customer) customer).getBalance());
        System.out.println("The customer's current totalPurchase is: $" + ((Customer) customer).getTotalPurchase());

        /**
         * The customer get a refund transaction and print the customer's balance and total purchase
         */
        ((Customer) customer).getTransaction((RefundTransaction) refundTransaction);
        System.out.println("After the refund transaction of " + ((RefundTransaction) refundTransaction).getTransactionId()
                + ", the customer's current balance is: $" + ((Customer) customer).getBalance());
        System.out.println("The customer's current totalPurchase is: $" + ((Customer) customer).getTotalPurchase());
        System.out.println("");


        /**
         * Test Payment, BankTransfer, CreditCardPay, DigitalWalletPay
         */
        System.out.println("Results of Payment, BankTransfer, CreditCardPay, and DigitalWalletPay:");

        /**
         * Create Payment objects and print the results of the overridden toString() methods
         */
        Payment bankerTransfer = new BankTransfer("JamesSmith25", "07/20/2024",
                63.2, "Bank of America");
        Payment creditCardPay = new CreditCardPay("LindaJohnson19", "07/25/2024",
                85, "2442977812");
        Payment digitalWalletPay = new DigitalWalletPay("MichaelBrown35", "08/02/2024",
                102, "PayPal");
        System.out.println(bankerTransfer.toString());
        System.out.println(creditCardPay.toString());
        System.out.println(digitalWalletPay.toString());

        /**
         * Create a new Payment object and compare objects
         * by the overridden hashCode() and equals() methods
         */
        Payment newBankerTransfer = new BankTransfer("JamesSmith25", "07/20/2024",
                63.2, "Bank of America");
        System.out.println("Are the hash code of bankerTransfer and newBankerTransfer the same? "
                + (bankerTransfer.hashCode() == newBankerTransfer.hashCode()));
        System.out.println("Are the object bankerTransfer and the object newBankerTransfer equal? "
                + (bankerTransfer.equals(newBankerTransfer)));

        /**
         * Create another Payment object and compare objects
         * by the overridden hashCode() and equals() methods
         */
        Payment newCreditCardPay = new CreditCardPay("LindaJohnson19", "07/25/2024",
                85, "2442977812");
        System.out.println("Are the hash code of creditCardPay and newCreditCardPay the same? "
                + (creditCardPay.hashCode() == newCreditCardPay.hashCode()));
        System.out.println("Are the object creditCardPay and the object newCreditCardPay equal? "
                + (creditCardPay.equals(newCreditCardPay)));

        /**
         * Create another Payment object and compare objects
         * by the overridden hashCode() and equals() methods
         */
        Payment newDigitalWalletPay = new DigitalWalletPay("MichaelBrown35", "08/02/2024",
                102, "PayPal");
        System.out.println("Are the hash code of digitalWalletPay and newDigitalWalletPay the same? "
                + (digitalWalletPay.hashCode() == newDigitalWalletPay.hashCode()));
        System.out.println("Are the object digitalWalletPay and object newDigitalWalletPay equal? "
                + (digitalWalletPay.equals(newDigitalWalletPay)));
    }
}