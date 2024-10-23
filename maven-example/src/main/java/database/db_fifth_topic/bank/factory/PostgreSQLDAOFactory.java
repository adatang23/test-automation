package database.db_fifth_topic.bank.factory;
import database.db_fifth_topic.bank.dao.AccountDAO;
import database.db_fifth_topic.bank.dao.AccountTypeDAO;
import database.db_fifth_topic.bank.dao.BranchDAO;
import database.db_fifth_topic.bank.dao.CustomerDAO;
import database.db_fifth_topic.bank.dao.jdbc.PostgreSQLCustomerDAO;
import database.db_fifth_topic.bank.exception.DAOException;


public class PostgreSQLDAOFactory extends DAOFactory {
    @Override
    public CustomerDAO getUserDAO() throws DAOException {
        return new PostgreSQLCustomerDAO();
    }

    @Override
    public AccountTypeDAO getAccountTypeDAO() throws DAOException {
        return null;
    }

    @Override
    public BranchDAO getBranchDAO() throws DAOException {
        return null;
    }

    @Override
    public AccountDAO getAccountDAO() throws DAOException {
        return null;
    }
}
