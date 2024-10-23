package database.db_fifth_topic.bank.exception;

public class DAOConfigurationException extends RuntimeException {
    public DAOConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOConfigurationException(String message) {
        super(message);
    }
}