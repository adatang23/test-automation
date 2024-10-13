package database.db_third_topic.bank.factory;
import database.db_third_topic.bank.dao.AccountTypeDAO;
import database.db_third_topic.bank.dao.BranchDAO;
import database.db_third_topic.bank.dao.CustomerDAO;
import database.db_third_topic.bank.dao.AccountDAO;
import database.db_third_topic.bank.dao.jdbc.MySQLAccountDAO;
import database.db_third_topic.bank.dao.jdbc.MySQLAccountTypeDAO;
import database.db_third_topic.bank.dao.jdbc.MySQLBranchDAO;
import database.db_third_topic.bank.dao.jdbc.MySQLCustomerDAO;
import database.db_third_topic.bank.exception.DAOException;


public class MySQLDAOFactory extends DAOFactory {
    @Override
    public CustomerDAO getUserDAO() throws DAOException {
        return new MySQLCustomerDAO();
    }

    @Override
    public AccountTypeDAO getAccountTypeDAO() throws DAOException {
        return new MySQLAccountTypeDAO();
    }

    @Override
    public BranchDAO getBranchDAO() throws DAOException {
        return new MySQLBranchDAO();
    }

    @Override
    public AccountDAO getAccountDAO() throws DAOException {
        return new MySQLAccountDAO();
    }
}
