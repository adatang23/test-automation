package java_basics.third_topic.page.banktransfer;

import java_basics.third_topic.page.common.TransactionPageBase;

public class TransactionPage extends TransactionPageBase {
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
        if (isValidBill(billName, price)) {
            if (totalSaving - price >= 0) {
                totalSaving -= price;
                System.out.println("The bill " + billName + " has been added to the Bank Transfer payment.");
            } else {
                System.out.println("Out of balance, the bill " + billName
                        + " has not been added to the Bank Transfer payment.");
            }
        } else {
            System.out.println("Invalid Bill");
        }
    }

    @Override
    public void removeBillFromPayment(String billName, double price) {
        if (isValidBill(billName, price)) {
            totalSaving += price;
            System.out.println("The bill " + billName + " was removed from the Bank Transfer payment.");
        } else {
            System.out.println("Invalid Bill");
        }
    }
    // Added the isValidBill() method
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
