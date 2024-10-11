package java_basics.second_topic.second_topic;

import java.util.Objects;
public class DigitalWalletPay extends Payment {
    private String brand;

    public DigitalWalletPay(String userId, String date, double price, String brand) {
        super(userId, date, price);
        this.brand = brand;
    }

    public final String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "The user with an ID of " + getUserId()
                + " paid $" + getPrice()
                + " through the digital wallet of " + brand
                + " on " + getDate() + ".";
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getDate(), getPrice(), brand);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            DigitalWalletPay digitalWalletPay = (DigitalWalletPay) obj;
            return (digitalWalletPay.getUserId().equals(this.getUserId())
                    && digitalWalletPay.getDate().equals(this.getDate())
                    && digitalWalletPay.getPrice() == this.getPrice()
                    && digitalWalletPay.brand.equals(this.brand));
        }
    }
}
