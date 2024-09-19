package fourth_topic.exceptions;

public class PaymentNotExistedException extends RuntimeException {
    public PaymentNotExistedException(String message) {
        super(message);
    }
}
