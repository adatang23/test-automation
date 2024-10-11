package java_basics.fourth_topic.exceptions;

public class InvalidPaymentIdException extends Exception {
    public InvalidPaymentIdException(String message) {
        super(message);
    }
}
