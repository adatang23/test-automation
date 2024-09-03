package fourth_topic;

public class InvalidPaymentMethodException extends RuntimeException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}
