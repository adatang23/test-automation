package database.db_third_topic.bank.dao;
import java.sql.SQLException;
import database.db_third_topic.bank.model.AccountType;


public interface AccountTypeDAO extends GenericDao<AccountType, Integer> {
    void create(AccountType element) throws SQLException;
    AccountType findById(Integer id) throws SQLException;
    void resetAutoIncrement() throws SQLException;
    void setSafeUpdates(Integer n) throws SQLException;
    void deleteAllAccountTypes() throws SQLException;
    void deleteAccountType(AccountType accountType) throws SQLException;
}
