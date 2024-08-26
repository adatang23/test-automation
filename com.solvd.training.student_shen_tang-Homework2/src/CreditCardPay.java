import java.util.Objects;
public class CreditCardPay extends Payment {
    private String cardNumber;

    public CreditCardPay(String userId, String date, double price, String cardNumber) {
        super(userId, date, price);
        this.cardNumber = cardNumber;
    }

    public final String getCardNumber() { return cardNumber; }

    @Override
    public String toString() { return "The user with an ID of " + getUserId()
            + " paid $" + getPrice() + " by a credit card with the card number "
            + cardNumber + " on " + getDate() + ".";}

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getDate(), getDate(), cardNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            CreditCardPay creditCardPay = (CreditCardPay) obj;
            return (creditCardPay.getUserId().equals(this.getUserId()) &&
                    creditCardPay.getDate().equals(this.getDate()) &&
                    creditCardPay.getPrice() == this.getPrice() &&
                    creditCardPay.cardNumber.equals(this.cardNumber));
        }
    }
}
