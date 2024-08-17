package third_topic.page.creditcardpay;

import third_topic.page.common.PaymentPageBase;

public class PaymentPage extends PaymentPageBase {
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
        if (totalCredit - price >= 0) {
            totalCredit -= price;
            System.out.println("The bill " + billName + " has been added to the Credit Card payment.");
        } else {
            System.out.println("Out of balance, the bill " + billName + " has not been added to the Credit Card payment.");
        }
    }

    @Override
    public void removeBillFromPayment(String billName, double price) {
        totalCredit += price;
        System.out.println("The bill " + billName + " was removed from the Credit Card payment.");
    }
}
