package database.db_third_topic.bank.dao.jdbc;
import database.db_third_topic.bank.connection.DBConnection;
import database.db_third_topic.bank.constant.ProjectConstant;
import database.db_third_topic.bank.dao.AccountTypeDAO;
import database.db_third_topic.bank.exception.DAOException;
import java.sql.*;

import static database.db_third_topic.bank.constant.ProjectConstant.*;
import static database.db_third_topic.bank.util.DAOUtil.preparedStatement;
import database.db_third_topic.bank.model.AccountType;
import database.db_third_topic.bank.model.Customer;


public class MySQLAccountTypeDAO implements AccountTypeDAO {
    @Override
    public void create(AccountType accountType) throws SQLException {
        if (accountType.getAccount_type_id() != null) {
            throw new IllegalArgumentException("Account Type is already created, the account_type_id is not null.");
        }
        Object[] values = {accountType.getAccount_type_name(), accountType.getInterest_rate()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement
                     = preparedStatement(connection, SQL_INSERT_ACCOUNT_TYPE, true, values)) {
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    accountType.setAccount_type_id(generatedKeys.getInt(1));
                    System.out.println("Successfully Inserted account_type_id " + generatedKeys.getInt(1));
                } else {
                    throw new DAOException("Creating account type failed, no generated key obtained.");
                }
            }
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
    public void resetAutoIncrement() throws SQLException {
        Integer start = 1;
        Object[] values = {start};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_RESET_AUTO_INCREMENT_ACCOUNT_TYPE,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteAllAccountTypes() throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_ALL_ACCOUNT_TYPE,
                     false)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteAccountType(AccountType accountType) throws SQLException {
        Object[] values = {accountType.getAccount_type_id()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_ACCOUNT_TYPE,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public AccountType findById(Integer id) throws SQLException {
        return find(id);
    }


    private AccountType find(Object... values) throws SQLException {
        AccountType accountType = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, ProjectConstant.SQL_FIND_BY_ACCOUNT_TYPE_ID,
                     false, values);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                accountType = getAccountTypeFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return accountType;
    }

    /**
     * Mapped AccountType from the current row of the given ResultSet
     */
    private AccountType getAccountTypeFromResultSet(ResultSet resultSet) throws SQLException {
        AccountType accountType = new AccountType();
        accountType.setAccount_type_id(resultSet.getInt("account_type_id"));
        accountType.setAccount_type_name(resultSet.getString("account_type_name"));
        accountType.setInterest_rate(resultSet.getDouble("interest_rate"));
        return accountType;
    }
}
