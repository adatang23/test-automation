package org.example;

public class PaymentNotExistedException extends RuntimeException {
    public PaymentNotExistedException(String message) {
        super(message);
    }
}
