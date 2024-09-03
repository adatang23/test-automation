package fourth_topic;

public class PaymentNotExistedException extends RuntimeException {
    public PaymentNotExistedException(String message) {
        super(message);
    }
}
