package third_topic.page.banktransfer;

import third_topic.page.common.PaymentPageBase;

public class PaymentPage extends PaymentPageBase {
    private String paymentName;
    private double totalSaving = 10000.0;

    // encapsulation
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public double getTotalSaving() {
        return totalSaving;
    }
    public void setTotalSaving(double totalSaving) {
        this.totalSaving = totalSaving;
    }

    // Inheritance and Polymorphism
    @Override
    public void openPage() {
        System.out.println("Opening Payment Page of Bank Transfer");
    }

    @Override
    public void addBillToPayment(String billName, double price) {
        if (totalSaving - price >= 0) {
            totalSaving -= price;
            System.out.println("The bill " + billName + " has been added to the Bank Transfer payment.");
        } else {
            System.out.println("Out of balance, the bill " + billName + " has not been added to the Bank Transfer payment.");
        }
    }

    @Override
    public void removeBillFromPayment(String billName, double price) {
        totalSaving += price;
        System.out.println("The bill " + billName + " was removed from the Bank Transfer payment.");
    }
}
