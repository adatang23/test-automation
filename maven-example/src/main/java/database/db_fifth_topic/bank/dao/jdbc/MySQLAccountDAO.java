package database.db_fifth_topic.bank.dao.jdbc;
import database.db_fifth_topic.bank.exception.DAOException;
import java.sql.*;
import static database.db_fifth_topic.bank.constant.ProjectConstant.SQL_DELETE_ACCOUNT;
import static database.db_fifth_topic.bank.constant.ProjectConstant.SQL_DELETE_ALL_ACCOUNT;
import static database.db_fifth_topic.bank.constant.ProjectConstant.SQL_INSERT_ACCOUNT;
import static database.db_fifth_topic.bank.constant.ProjectConstant.SQL_RESET_AUTO_INCREMENT_ACCOUNT;
import static database.db_fifth_topic.bank.constant.ProjectConstant.SQL_SET_SAFE_UPDATES;
import static database.db_fifth_topic.bank.constant.ProjectConstant.SQL_UPDATE_ACCOUNT_BALANCE;
import database.db_fifth_topic.bank.model.Account;
import database.db_fifth_topic.bank.connection.DBConnection;
import database.db_fifth_topic.bank.dao.AccountDAO;
import database.db_fifth_topic.bank.util.DAOUtil;

public class MySQLAccountDAO implements AccountDAO {
    @Override
    public void create(Account account) throws SQLException {
        if (account.getAccount_id() != null) {
            throw new IllegalArgumentException("Account is already created, the account_id is not null.");
        }
        Object[] values = {account.getUser_id(), account.getAccount_opened(), account.getType_id(),
                account.getBalance(), account.getBranch_id()};
        try (Connection connection = database.db_fifth_topic.bank.connection.DBConnection.getConnection();
             PreparedStatement statement
                     = DAOUtil.preparedStatement(connection, SQL_INSERT_ACCOUNT, true, values)) {
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    account.setAccount_id(generatedKeys.getInt(1));
                    System.out.println("Successfully Inserted account_id " + generatedKeys.getInt(1));
                } else {
                    throw new DAOException("Creating account failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void updateAccountBalance(Account account, Double balance) throws SQLException {
        if (account.getAccount_id() == null) {
            throw new IllegalArgumentException("Account does not existed.");
        }
        Object[] values = {balance, account.getAccount_id()};
        try (Connection connection = database.db_fifth_topic.bank.connection.DBConnection.getConnection();
             PreparedStatement statement
                     = DAOUtil.preparedStatement(connection, SQL_UPDATE_ACCOUNT_BALANCE, false, values)) {
            statement.executeUpdate();
        } catch(SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void setSafeUpdates(Integer n) throws SQLException {
        Object[] values = {n};
        try (Connection connection = database.db_fifth_topic.bank.connection.DBConnection.getConnection();
             PreparedStatement statement = DAOUtil.preparedStatement(connection, SQL_SET_SAFE_UPDATES,
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
        try (Connection connection = database.db_fifth_topic.bank.connection.DBConnection.getConnection();
             PreparedStatement statement = DAOUtil.preparedStatement(connection, SQL_RESET_AUTO_INCREMENT_ACCOUNT,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteAllAccounts() throws SQLException {
        try (Connection connection = database.db_fifth_topic.bank.connection.DBConnection.getConnection();
             PreparedStatement statement = DAOUtil.preparedStatement(connection, SQL_DELETE_ALL_ACCOUNT,
                     false)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteAccount(Account account) throws SQLException {
        Object[] values = {account.getAccount_id()};
        try (Connection connection = database.db_fifth_topic.bank.connection.DBConnection.getConnection();
             PreparedStatement statement = DAOUtil.preparedStatement(connection, SQL_DELETE_ACCOUNT,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Account findById(Integer id) throws SQLException { return find(id); }

    private Account find(Object... values) throws SQLException {
        Account account = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = DAOUtil.preparedStatement(connection, database.db_fifth_topic.bank.constant.ProjectConstant.SQL_FIND_BY_ACCOUNT_ID,
                     false, values);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                account = getAccountFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return account;
    }

    /**
     * Mapped Account from the current row of the given ResultSet
     */
    private Account getAccountFromResultSet(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        account.setAccount_id(resultSet.getInt("account_id"));
        account.setUser_id(resultSet.getInt("user_id"));
        account.setAccount_opened(resultSet.getString("account_opened"));
        account.setType_id(resultSet.getInt("type_id"));
        account.setBalance(resultSet.getDouble("balance"));
        account.setBranch_id(resultSet.getInt("branch_id"));
        return account;
    }
}
