package projects.first_topic.smart_bank_app.dao.jdbc;
import projects.first_topic.smart_bank_app.constant.ProjectConstant;
import projects.first_topic.smart_bank_app.model.Transaction;
import projects.first_topic.smart_bank_app.connection.DBConnection;
import projects.first_topic.smart_bank_app.dao.*;
import projects.first_topic.smart_bank_app.exception.DAOException;
import java.sql.*;
import static projects.first_topic.smart_bank_app.constant.ProjectConstant.*;
import static projects.first_topic.smart_bank_app.util.DAOUtil.preparedStatement;


public class MySQLTransactionManager implements ITransactionManagement {
    @Override
    public void create(Transaction transaction) throws SQLException {
        if (transaction.getTransaction_id() != null) {
            throw new IllegalArgumentException("Transaction is already created, the transaction_id is not null.");
        }
        Object[] values = {transaction.getAccount_id(), transaction.getTransaction_type(),
                transaction.getTransaction_amount(), transaction.getTransaction_date()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement
                     = preparedStatement(connection, SQL_INSERT_TRANSACTION, true, values)) {
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    transaction.setTransaction_id(generatedKeys.getInt(1));
                    System.out.println("Successfully Inserted transaction_id " + generatedKeys.getInt(1));
                } else {
                    throw new DAOException("Creating transaction failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Transaction findById(Integer id) throws SQLException {
        return find(id);
    }

    private Transaction find(Object... values) throws SQLException {
        Transaction transaction = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, ProjectConstant.SQL_FIND_BY_TRANSACTION_ID,
                     false,values);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                transaction = getTransactionFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return transaction;
    }

    /**
     * Mapped Account from the current row of the given ResultSet
     */
    private Transaction getTransactionFromResultSet(ResultSet resultSet) throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setTransaction_id(resultSet.getInt("transaction_id"));
        transaction.setAccount_id(resultSet.getInt("account_id"));
        transaction.setTransaction_type(resultSet.getString("transaction_type"));
        transaction.setTransaction_amount(resultSet.getDouble("transaction_amount"));
        transaction.setTransaction_date(resultSet.getString("transaction_date"));
        return transaction;
    }


    @Override
    public void resetAutoIncrement() throws SQLException {
        Integer start = 1;
        Object[] values = {start};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_RESET_AUTO_INCREMENT_TRANSACTION,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void setSafeUpdates(Integer n) throws SQLException {
        Object[] values = {n};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_SET_SAFE_UPDATES,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteAllTransactions() throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_ALL_TRANSACTION,
                     false)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteTransaction(Transaction transaction) throws SQLException {
        Object[] values = {transaction.getTransaction_id()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_TRANSACTION,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
