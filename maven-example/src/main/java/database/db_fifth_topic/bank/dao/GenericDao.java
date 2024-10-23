package database.db_fifth_topic.bank.dao;
import java.sql.*;

public interface GenericDao<T, V> {
    void create(T element) throws SQLException;
    T findById(V id) throws SQLException;
}
