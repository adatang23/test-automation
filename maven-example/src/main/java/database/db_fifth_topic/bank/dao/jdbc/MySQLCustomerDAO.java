package database.db_fifth_topic.bank.dao.jdbc;
import database.db_fifth_topic.bank.connection.DBConnection;
import database.db_fifth_topic.bank.constant.ProjectConstant;
import database.db_fifth_topic.bank.dao.CustomerDAO;
import database.db_fifth_topic.bank.exception.DAOException;
import java.sql.*;
import static database.db_fifth_topic.bank.constant.ProjectConstant.*;
import static database.db_fifth_topic.bank.util.DAOUtil.preparedStatement;
import database.db_fifth_topic.bank.model.Customer;

public class MySQLCustomerDAO implements CustomerDAO {
    @Override
    public void create(Customer customer) throws SQLException {
        if (customer.getCustomer_id() != null) {
            throw new IllegalArgumentException("Customer is already created, the customer_id is not null.");
        }
        Object[] values = {customer.getUser_name(), customer.getPassword(),
                customer.getFirst_name(), customer.getLast_name(), customer.getPhone(),
                customer.getEmail(), customer.getRegistration_date()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement
                     = preparedStatement(connection, SQL_INSERT_CUSTOMER, true, values)) {
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    customer.setCustomer_id(generatedKeys.getInt(1));
                    System.out.println("Successfully Inserted customer_id " + generatedKeys.getInt(1));
                } else {
                    throw new DAOException("Creating customer failed, no generated key obtained.");
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }


    @Override
    public void updatePassword(Customer customer, String password) throws SQLException {
        if (customer.getCustomer_id() == null) {
            throw new IllegalArgumentException("Customer does not existed.");
        }
        Object[] values = {password, customer.getCustomer_id()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement
                     = preparedStatement(connection, SQL_UPDATE_CUSTOMER_PASSWORD, false, values)) {
            statement.executeUpdate();
        } catch(SQLException e) {
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
             PreparedStatement statement = preparedStatement(connection, SQL_RESET_AUTO_INCREMENT_CUSTOMER,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteAllCustomers() throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_ALL_CUSTOMER,
                     false)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException {
        Object[] values = {customer.getCustomer_id()};
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, SQL_DELETE_CUSTOMER,
                     false, values)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public Customer findById(Integer id) throws SQLException { return find(id); }

    private Customer find(Object... values) throws SQLException {
        Customer customer = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = preparedStatement(connection, ProjectConstant.SQL_FIND_BY_CUSTOMER_ID,
                     false, values);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                customer = getCustomerFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return customer;
    }

    /**
     * Mapped User from the current row of the given ResultSet
     */
    private Customer getCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomer_id(resultSet.getInt("customer_id"));
        customer.setUser_name(resultSet.getString("user_name"));
        customer.setPassword(resultSet.getString("password"));
        customer.setFirst_name(resultSet.getString("first_name"));
        customer.setLast_name(resultSet.getString("last_name"));
        customer.setPhone(resultSet.getString("phone"));
        customer.setEmail(resultSet.getString("email"));
        customer.setRegistration_date(resultSet.getString("registration_date"));
        return customer;
    }
}
