package database.db_third_topic.bank.dao;
import java.sql.*;

public interface GenericDao<T, V> {
    void create(T element) throws SQLException;
    T findById(V id) throws SQLException;
}
