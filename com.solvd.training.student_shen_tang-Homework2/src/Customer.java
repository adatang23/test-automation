import java.util.Objects;

public class Customer extends User {
    private double balance;
    private double totalPurchase;
    public Customer(String userId, String password, double balance, double totalPurchase) {
        super(userId, password);
        this.balance = balance;
        this.totalPurchase = totalPurchase;
    }
    public double getBalance() { return balance; }
    public double getTotalPurchase() { return totalPurchase; }
    public void getTransaction(Object obj) {
        if (obj instanceof SaleTransaction) {
            balance -= ((SaleTransaction) obj).getPrice();
            totalPurchase += ((SaleTransaction) obj).getPrice();
        } else if (obj instanceof RefundTransaction) {
            balance += ((RefundTransaction) obj).getPrice();
        }
    }
    @Override
    public String toString() { return "The customer with an ID of " + getUserId()
            + " has a balance of $" + balance + " with a total purchase of $" + totalPurchase + "."; }
    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getPassword(), balance, totalPurchase);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            Customer customer = (Customer) obj;
            return (customer.getUserId().equals(this.getUserId()) &&
                    customer.getPassword().equals(this.getPassword()) &&
                    customer.balance == this.balance &&
                    customer.totalPurchase == this.totalPurchase);
        }
    }
}
