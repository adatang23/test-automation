package database.db_third_topic.bank.exception;

import java.sql.SQLException;

public class DAOException extends SQLException {
    public DAOException(String message) {
        super(message);
    }
}
