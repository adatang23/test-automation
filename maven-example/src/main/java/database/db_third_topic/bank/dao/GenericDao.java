package database.db_third_topic.bank.dao;
import database.db_third_topic.bank.model.Customer;

import java.sql.*;

public interface GenericDao<T, V> {
    void create(T element) throws SQLException;
    T findById(V id) throws SQLException;
    void updatePassword(T element, String password) throws SQLException;
    void resetAutoIncrement() throws SQLException;
    void setSafeUpdates(Integer n) throws SQLException;
    void deleteAllCustomers() throws SQLException;
    void deleteCustomer(T element) throws SQLException;
}
