package third_topic.page.creditcardpay;
import third_topic.page.common.TransactionPageBase;
public class TransactionPage extends TransactionPageBase {
    private String paymentName;
    private double totalCredit = 3000.0;

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

    public double getTotalCredit() {
        return totalCredit;
    }

    public void setTotalSaving(double totalCredit) {
        try {
            if (totalCredit < 0) {
                System.out.println("Please input a valid value.");
            } else {
                this.totalCredit = totalCredit;
            }
        } catch(Exception e) {
            System.out.println("Please input a value.");
        }
    }

    // Inheritance and Polymorphism
    @Override
    public void openPage() {
        System.out.println("Opening Payment Page of Credit Card Pay");
    }

    @Override
    public void addBillToPayment(String billName, double price) {
        try {
            if (billName.strip().equals("")) {
                System.out.println("Please enter a bill name.");
            } else if (price < 0) {
                System.out.println("Please enter a valid price.");
            } else if (totalCredit - price >= 0) {
                totalCredit -= price;
                System.out.println("The bill " + billName + " has been added to the Credit Card payment.");
            } else {
                System.out.println("Out of balance, the bill " + billName
                        + " has not been added to the Credit Card payment.");
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
                totalCredit += price;
                System.out.println("The bill " + billName + " was removed from the Credit Card payment.");
            }
        } catch (Exception e) {
            System.out.println("Please enter a bill name and a price.");
        }
    }
}
