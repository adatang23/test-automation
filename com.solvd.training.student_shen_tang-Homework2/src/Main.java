import javax.swing.text.DefaultEditorKit;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Transaction, SaleTransaction, RefundTransaction, User, Customer, and Admin
        System.out.println("Results of Transaction, SaleTransaction, and RefundTransaction:");
        Transaction saleTransaction = new SaleTransaction("SaleTrans25", 1100, "Desktop");
        Transaction refundTransaction = new RefundTransaction("RefundTrans19", 30, "JamesSmith25");

        System.out.println(saleTransaction.toString());
        System.out.println(refundTransaction.toString());

        Transaction newSaleTransaction = new SaleTransaction("SaleTrans25", 1100, "Desktop");
        System.out.println("Are the hash code of saleTransaction and newSaleTransaction the same? " +
                (saleTransaction.hashCode() == newSaleTransaction.hashCode()));
        System.out.println("Are saleTransaction and newSaleTransaction the same object? " +
                (saleTransaction.equals(newSaleTransaction)));

        Transaction newRefundTransaction = new RefundTransaction("RefundTrans19", 30, "JamesSmith25");
        System.out.println("Are the hash code of refundTransaction and newRefundTransaction the same? " +
                (refundTransaction.hashCode() == newRefundTransaction.hashCode()));
        System.out.println("Are refundTransaction and newRefundTransaction the same object? " +
                (refundTransaction.equals(newRefundTransaction)));
        System.out.println("");

        // User, Customer, and Admin
        System.out.println("Results of User, Customer, and Admin:");
        User customer = new Customer("JamesSmith25", "123456", 5000, 800);
        User admin = new Admin("MichaelBrown35", "654321", new String[] {"SaleTrans25", "RefundTrans19"}, new String[] {"JamesSmith25", "LindaJohnson19"});

        System.out.println(customer.toString());
        System.out.println(admin.toString());

        User newCustomer = new Customer("JamesSmith25", "123456", 5000, 800);
        System.out.println("Are the hash code of customer and newCustomer the same? " +
                (customer.hashCode() == newCustomer.hashCode()));
        System.out.println("Are customer and newCustomer the same object? " +
                (customer.equals(newCustomer)));

        User newAdmin = new Admin("MichaelBrown35", "654321", new String[] {"SaleTrans25", "RefundTrans19"}, new String[] {"JamesSmith25", "LindaJohnson19"});
        System.out.println("Are the hash code of admin and newAdmin the same? " +
                (admin.hashCode() == newAdmin.hashCode()));
        System.out.println("Are admin and newAdmin the same object? " +
                (admin.equals(newAdmin)));

        System.out.println(Arrays.toString(((Admin) admin).getTransactionList()));
        System.out.println(Arrays.toString(((Admin) admin).getUserList()));
        System.out.println("");

        // Customer and Transaction
        System.out.println("Results of Customer and Transaction:");
        System.out.println("The customer's balance is: $" + ((Customer) customer).getBalance());
        System.out.println("The customer's total purchase is: $" + ((Customer) customer).getTotalPurchase());
        ((Customer) customer).getTransaction((SaleTransaction) saleTransaction);
        System.out.println("After the sale transaction of " + ((SaleTransaction) saleTransaction).getTransactionId() + ", the customer's current balance is: $" + ((Customer) customer).getBalance());
        System.out.println("The customer's current totalPurchase is: $" + ((Customer) customer).getTotalPurchase());
        ((Customer) customer).getTransaction((RefundTransaction) refundTransaction);
        System.out.println("After the refund transaction of " + ((RefundTransaction) refundTransaction).getTransactionId() + ", the customer's current balance is: $" + ((Customer) customer).getBalance());
        System.out.println("The customer's current totalPurchase is: $" + ((Customer) customer).getTotalPurchase());
        System.out.println("");



        // Payment, BankTransfer, CreditCardPay, DigitalWalletPay
        System.out.println("Results of Payment, BankTransfer, CreditCardPay, and DigitalWalletPay:");
        Payment bankerTransfer = new BankTransfer("JamesSmith25", "07/20/2024", 63.2, "Bank of America");
        Payment creditCardPay = new CreditCardPay("LindaJohnson19", "07/25/2024", 85, "2442977812");
        Payment digitalWalletPay = new DigitalWalletPay("MichaelBrown35", "08/02/2024", 102, "PayPal");

        System.out.println(bankerTransfer.toString());
        System.out.println(creditCardPay.toString());
        System.out.println(digitalWalletPay.toString());

        Payment newBankerTransfer = new BankTransfer("JamesSmith25", "07/20/2024", 63.2, "Bank of America");
        System.out.println("Are the hash code of bankerTransfer and newBankerTransfer the same? " +
                (bankerTransfer.hashCode() == newBankerTransfer.hashCode()));
        System.out.println("Are the object bankerTransfer and the object newBankerTransfer equal? " +
                (bankerTransfer.equals(newBankerTransfer)));

        Payment newCreditCardPay = new CreditCardPay("LindaJohnson19", "07/25/2024", 85, "2442977812");
        System.out.println("Are the hash code of creditCardPay and newCreditCardPay the same? " +
                (creditCardPay.hashCode() == newCreditCardPay.hashCode()));
        System.out.println("Are the object creditCardPay and the object newCreditCardPay equal? " +
                (creditCardPay.equals(newCreditCardPay)));

        Payment newDigitalWalletPay = new DigitalWalletPay("MichaelBrown35", "08/02/2024", 102, "PayPal");
        System.out.println("Are the hash code of digitalWalletPay and newDigitalWalletPay the same? " +
                (digitalWalletPay.hashCode() == newDigitalWalletPay.hashCode()));
        System.out.println("Are the object digitalWalletPay and object newDigitalWalletPay equal? " +
                (digitalWalletPay.equals(newDigitalWalletPay)));
    }
}