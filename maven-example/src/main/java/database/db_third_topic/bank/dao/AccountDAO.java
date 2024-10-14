package database.db_third_topic.bank.dao;
import database.db_third_topic.bank.model.Account;
import java.sql.SQLException;

public interface AccountDAO extends GenericDao<Account, Integer> {
    void create(Account element) throws SQLException;
    Account findById(Integer id) throws SQLException;
    void resetAutoIncrement() throws SQLException;
    void updateAccountBalance(Account account, Double balance) throws SQLException;
    void setSafeUpdates(Integer n) throws SQLException;
    void deleteAllAccounts() throws SQLException;
    void deleteAccount(Account account) throws SQLException;
}
