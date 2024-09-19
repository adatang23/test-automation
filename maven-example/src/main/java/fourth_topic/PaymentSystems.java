package fourth_topic;
import fourth_topic.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class PaymentSystems {
    protected static final String[] AVAILABLE_PAYMENTS = {
            "CreditCardPay02", "CreditCardPay05", "BankTransfer06", "DigitalWalletPay08",
            "DigitalWalletPay07", "CreditCardPay09", "BankTransfer10", "DigitalWalletPay11"};
    private static double credit = 3000.0;

    private static final Logger log = LogManager.getLogger(PaymentSystems.class.getName());

    /**
     * Handle exceptions in try-catch way, Test getPaymentById(String paymentId) method
     * with PaymentIdNotFoundException, InvalidPaymentIdException
     */
    public Payment getPaymentById(String paymentId) throws
            PaymentIdNotFoundException, InvalidPaymentIdException {
        try {
            if (paymentId == null || paymentId.length() < 6 || paymentId.length() > 30) {
                log.error("Invalid payment ID: " + paymentId
                        + ", the ID should contain 6-30 characters.");
                throw new InvalidPaymentIdException("Invalid payment ID: "
                        + paymentId + " (wrong length)");
            }
            for (int i = 0; i < paymentId.length(); i++) {
                if (!Character.isLetterOrDigit(paymentId.charAt(i))) {
                    log.error("Invalid payment ID: " + paymentId
                            + ", alphanumeric only.");
                    throw new InvalidPaymentIdException("Invalid payment ID: "
                            + paymentId + " (invalid character)");
                }
            }
            Payment payment = findPaymentById(paymentId);
            if (payment == null) {
                log.warn("Can't find payment with ID: " + paymentId
                        + ", trying next ID from list.");
                for (String nextPaymentId : AVAILABLE_PAYMENTS) {
                    if (!nextPaymentId.equals(paymentId)) {
                        payment = findPaymentById(nextPaymentId);
                        if (payment != null) {
                            log.info("Found payment with ID: " + nextPaymentId);
                            return payment;
                        }
                    }
                }
                throw new PaymentIdNotFoundException("Can't find payment with ID: "
                        + paymentId + " or any other payment.");
            }
            return payment;
        } catch (InvalidPaymentIdException e) {
            log.fatal("Error retrieving invalid payment id: " + e.getMessage());
            throw e;
        } catch (PaymentIdNotFoundException e) {
            log.fatal("Error retrieving payment: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Handle Exceptions in try-catch-finally way, Test transaction(Object obj) method
     * with PaymentNotExistedException, InvalidPaymentMethodException, InvalidPaymentAmountException
     */
    public Payment transaction(Object obj) throws PaymentNotExistedException,
            InvalidPaymentMethodException, InvalidPaymentAmountException {
        try {
            if (obj == null) {
                log.error("Payment is not existed.");
                throw new PaymentNotExistedException("Can't find the payment, try an existed one.");
            } else if (obj instanceof Payment) {
                log.info("Valid Payment Method: " + obj.getClass().toString());
                Payment pay = (Payment) obj;
                if (pay.getAmount() <= 0) {
                    log.error("Invalid Transaction amount: " + pay.getAmount());
                    throw new InvalidPaymentAmountException("Can't transact $"
                            + pay.getAmount() + ", try a valid amount");
                } else if (pay.getAmount() > credit) {
                    log.error("Invalid Transaction amount (exceed credit limit): "
                            + pay.getAmount());
                    throw new InvalidPaymentAmountException("Can't transact $"
                            + pay.getAmount() + ", don't exceed credit limit");
                }
                credit -= ((Payment) obj).getAmount();
                return pay;
            }
            log.error("Invalid Payment Method: " + obj.getClass().toString());
            throw new InvalidPaymentMethodException("Can't find payment method: "
                    + obj.getClass().toString() + ", try a valid method.");
        } catch (PaymentNotExistedException e) {
            log.fatal("Error retrieving invalid payment: " + e.getMessage());
            throw e;
        } catch (InvalidPaymentMethodException e) {
            log.fatal("Error retrieving invalid payment method: " + e.getMessage());
            throw e;
        } catch(InvalidPaymentAmountException e) {
            log.fatal("Error retrieving invalid payment amount: " + e.getMessage());
            throw e;
        } finally {
            // Try to protect the credit if the payment is invalid
            if (obj == null || !(obj instanceof Payment) || ((Payment) obj).getAmount() <= 0) {
                credit = 3000.0;
            }
            System.out.println("Current credit: " + credit);
        }
    }

    /**
     * Handle Exceptions in try-with-resource way, Test readPaymentFile(String filename) method
     * with IOException
     */
    public void readPaymentFile(String filename) throws IOException {
        try(FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedInput = new BufferedInputStream(input)) {
            int data = input.read();
            while (data != -1) {
                System.out.println((char) data);
                data = input.read();
            }
        } catch (IOException e) {
            log.fatal("Can't find the payment file: " + e.getMessage());
            throw new IOException("Can't find payment file: "
                    + filename + ", try a valid file.");
        } finally {
            System.out.println("The file is closed.");
        }
    }

    public Payment findPaymentById(String paymentId) {
        /* In a real application, this would search for the payment from a database */
        return null;
    }

    /**
     * Inner class representing a Payment
     */
    public static class Payment {
        double amount;
        public Payment(double amount) {
            this.amount = amount;
        }
        public double getAmount() {
            return amount;
        }
    }

    public static class InvalidMethod {
        double amount;
        public InvalidMethod(double amount) { this.amount = amount; }
        public double getAmount() { return amount; }
    }

    public static class CreditCard extends Payment {
        public CreditCard(double amount) {
            super(amount);
        }
    }

    public static class BankTransfer extends Payment {
        public BankTransfer(double amount) {
            super(amount);
        }
    }

    public static class DigitalWallet extends Payment {
        public DigitalWallet(double amount) {
            super(amount);
        }
    }

    /**
     * Test the log levels
     */
    public void Log4j2Test() {
        log.fatal("This is the fatal level.");
        log.error("This is the error level.");
        log.warn("This is the warn level.");
        log.info("This is the info level.");
        log.debug("This is the debug level.");
        log.trace("This is the trace level.");
    }
}