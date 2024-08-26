package org.example;

public class InvalidPaymentIdException extends Exception {
    public InvalidPaymentIdException(String message) {
        super(message);
    }
}
