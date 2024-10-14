package database.db_third_topic.bank.services;
import java.sql.*;
import database.db_third_topic.bank.dao.CustomerDAO;
import database.db_third_topic.bank.exception.DAOException;
import database.db_third_topic.bank.factory.DAOFactory;
import database.db_third_topic.bank.model.Customer;

public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(DAOFactory daoFactory) throws DAOException {
        this.customerDAO = daoFactory.getUserDAO();
    }

    public void createCustomer(Customer customer) throws SQLException {
        customerDAO.create(customer);
    }

    public void updatePassword(Customer customer, String password) throws SQLException {
        customerDAO.updatePassword(customer, password);
    }

    public void resetAutoIncrement() throws SQLException {
        customerDAO.resetAutoIncrement();
    }

    public void setSafeUpdates(Integer n) throws SQLException{
        customerDAO.setSafeUpdates(n);
    }

    public void deleteAllCustomers() throws SQLException {
        customerDAO.deleteAllCustomers();
    }

    public void deleteCustomer(Customer customer) throws SQLException {
        customerDAO.deleteCustomer(customer);
    }

    public Customer getCustomer(Integer id) throws SQLException {
        return customerDAO.findById(id);
    }
}
