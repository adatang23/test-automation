import java.util.Objects;
public class Payment {
    private String userId;
    private String date;
    private double price;

    public Payment(String userId, String date, double price) {
        this.userId = userId;
        this.date = date;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "The user with an ID of " + userId
                + " paid $" + price
                + " on " + date + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, date, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            Payment payment = (Payment) obj;
            return (payment.userId.equals(this.userId)
                    && payment.date.equals(this.date)
                    && payment.price == this.price);
        }
    }
}
