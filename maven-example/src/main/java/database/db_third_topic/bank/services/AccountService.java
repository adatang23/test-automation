package database.db_third_topic.bank.services;
import java.sql.*;
import database.db_third_topic.bank.dao.AccountDAO;
import database.db_third_topic.bank.dao.AccountTypeDAO;
import database.db_third_topic.bank.exception.DAOException;
import database.db_third_topic.bank.factory.DAOFactory;
import database.db_third_topic.bank.model.Account;
import database.db_third_topic.bank.model.AccountType;


public class AccountService {
    private final AccountDAO accountDAO;
    public AccountService(DAOFactory daoFactory) throws DAOException {
        this.accountDAO = daoFactory.getAccountDAO();
    }

    public void createAccount(Account account) throws SQLException {
        accountDAO.create(account);
    }


    public void resetAutoIncrement() throws SQLException {
        accountDAO.resetAutoIncrement();
    }

    public void setSafeUpdates(Integer n) throws SQLException {
        accountDAO.setSafeUpdates(n);
    }

    public void updateAccountBalance(Account account, Double balance) throws SQLException{
        accountDAO.updateAccountBalance(account, balance);
    }

    public void deleteAllAccounts() throws SQLException {
        accountDAO.deleteAllAccounts();
    }

    public void deleteAccount(Account account) throws SQLException {
        accountDAO.deleteAccount(account);
    }

    public Account getAccount(Integer id) throws SQLException {
        return accountDAO.findById(id);
    }
}
