package java_basics.third_topic.third_topic.page.creditcardpay;
import java_basics.third_topic.third_topic.page.common.TransactionPageBase;
public class TransactionPage extends TransactionPageBase {
    private String paymentName;
    private double totalCredit = 3000.0;

    // encapsulation
    public String getPaymentName() {
        return paymentName;
    }
    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

    // Inheritance and Polymorphism
    @Override
    public void openPage() {
        System.out.println("Opening Payment Page of Credit Card Pay");
    }

    @Override
    public void addBillToPayment(String billName, double price) {
        if (isValidBill(billName, price)) {
            if (totalCredit - price >= 0) {
                totalCredit -= price;
                System.out.println("The bill " + billName + " has been added to the Credit Card payment.");
            } else {
                System.out.println("Out of balance, the bill "
                        + billName + " has not been added to the Credit Card payment.");
            }
        } else {
            System.out.println("Invalid Bill");
        }
    }

    @Override
    public void removeBillFromPayment(String billName, double price) {
        if (isValidBill(billName, price)) {
            totalCredit += price;
            System.out.println("The bill " + billName + " was removed from the Credit Card payment.");
        } else {
            System.out.println("Invalid Bill");
        }
    }

    private boolean isValidBill(String billName, double price) {
        if (billName == null || billName.strip().isEmpty()) {
            System.out.println("Please enter a bill name.");
            return false;
        } else if (price < 0) {
            System.out.println("Please enter a valid price.");
            return false;
        }
        return true;
    }
}
