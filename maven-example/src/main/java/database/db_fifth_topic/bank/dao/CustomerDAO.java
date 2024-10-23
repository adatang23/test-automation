package database.db_fifth_topic.bank.dao;
import java.sql.SQLException;
import database.db_fifth_topic.bank.model.Customer;

public interface CustomerDAO {
    void create(Customer element) throws SQLException;
    Customer findById(Integer id) throws SQLException;
    void updatePassword(Customer element, String password) throws SQLException;
    void resetAutoIncrement() throws SQLException;
    void setSafeUpdates(Integer n) throws SQLException;
    void deleteAllCustomers() throws SQLException;
    void deleteCustomer(Customer customer) throws SQLException;
}
