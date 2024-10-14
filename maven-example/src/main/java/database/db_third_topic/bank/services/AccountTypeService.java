package database.db_third_topic.bank.services;
import java.sql.*;
import database.db_third_topic.bank.dao.AccountTypeDAO;
import database.db_third_topic.bank.exception.DAOException;
import database.db_third_topic.bank.factory.DAOFactory;
import database.db_third_topic.bank.model.AccountType;


public class AccountTypeService {
    private final AccountTypeDAO accountTypeDAO;

    public AccountTypeService(DAOFactory daoFactory) throws DAOException {
        this.accountTypeDAO = daoFactory.getAccountTypeDAO();
    }

    public void createAccountType(AccountType accountType) throws SQLException {
        accountTypeDAO.create(accountType);
    }

    public void resetAutoIncrement() throws SQLException {
        accountTypeDAO.resetAutoIncrement();
    }

    public void setSafeUpdates(Integer n) throws SQLException{
        accountTypeDAO.setSafeUpdates(n);
    }

    public void deleteAllAccountTypes() throws SQLException {
        accountTypeDAO.deleteAllAccountTypes();
    }

    public void deleteAccountType(AccountType accountType) throws SQLException {
        accountTypeDAO.deleteAccountType(accountType);
    }

    public AccountType getAccountType(Integer id) throws SQLException {
        return accountTypeDAO.findById(id);
    }
}
