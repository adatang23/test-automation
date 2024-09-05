package third_topic.page.banktransfer;

import third_topic.page.common.TransactionPageBase;

public class TransactionPage extends TransactionPageBase {
    private String paymentName;
    private double totalSaving = 10000.0;

    // encapsulation
    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        try {
            if (paymentName.strip().equals("")) {
                System.out.println("Please enter a valid payment name.");
            } else {
                this.paymentName = paymentName;
            }
        } catch(Exception e) {
            System.out.println("Please enter a payment name.");
        }
    }

    public double getTotalSaving() {
        return totalSaving;
    }

    public void setTotalSaving(double totalSaving) {
        try {
            if (totalSaving < 0) {
                System.out.println("Please input a valid value.");
            } else {
                this.totalSaving = totalSaving;
            }
        } catch(Exception e) {
            System.out.println("Please input a value.");
        }
    }

    // Inheritance and Polymorphism
    @Override
    public void openPage() {
        System.out.println("Opening Payment Page of Bank Transfer");
    }

    @Override
    public void addBillToPayment(String billName, double price) {
        try {
            if (billName.strip().equals("")) {
                System.out.println("Please enter a bill name.");
            } else if (price < 0) {
                System.out.println("Please enter a valid price.");
            } else if (totalSaving - price >= 0) {
                totalSaving -= price;
                System.out.println("The bill " + billName + " has been added to the Bank Transfer payment.");
            } else {
                System.out.println("Out of balance, the bill " + billName
                        + " has not been added to the Bank Transfer payment.");
            }
        } catch(Exception e) {
            System.out.println("Please enter a bill name and a price.");
        }
    }

    @Override
    public void removeBillFromPayment(String billName, double price) {
        try {
            if (billName.strip().equals("")) {
                System.out.println("Please enter a bill name.");
            } else if (price < 0) {
                System.out.println("Please enter a valid price.");
            } else {
                totalSaving += price;
                System.out.println("The bill " + billName + " was removed from the Bank Transfer payment.");
            }
        } catch (Exception e) {
            System.out.println("Please enter a bill name and a price.");
        }
    }
}
