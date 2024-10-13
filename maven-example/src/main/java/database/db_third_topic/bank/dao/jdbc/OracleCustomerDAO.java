package database.db_third_topic.bank.dao.jdbc;
import database.db_third_topic.bank.dao.CustomerDAO;
import database.db_third_topic.bank.model.Customer;
import java.sql.SQLException;

public class OracleCustomerDAO implements CustomerDAO {
    @Override
    public void create(Customer element) throws SQLException {
        // Omit the implementation
    }

    @Override
    public Customer findById(Integer id) throws SQLException {
        // Omit the implementation
        return null;
    }

    @Override
    public void updatePassword(Customer element, String password) throws SQLException {
        // Omit the implementation
    }

    @Override
    public void resetAutoIncrement() throws SQLException {
        // Omit the implementation
    }

    @Override
    public void setSafeUpdates(Integer n) throws SQLException {
        // Omit the implementation
    }

    @Override
    public void deleteAllCustomers() throws SQLException {
        // Omit the implementation
    }

    @Override
    public void deleteCustomer(Customer customer) throws SQLException {
        // Omit the implementation
    }
}
