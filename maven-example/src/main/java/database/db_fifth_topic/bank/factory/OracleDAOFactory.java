package database.db_fifth_topic.bank.factory;
import database.db_fifth_topic.bank.dao.AccountDAO;
import database.db_fifth_topic.bank.dao.AccountTypeDAO;
import database.db_fifth_topic.bank.dao.BranchDAO;
import database.db_fifth_topic.bank.exception.DAOException;
import database.db_fifth_topic.bank.dao.jdbc.*;
import database.db_fifth_topic.bank.dao.CustomerDAO;


public class OracleDAOFactory extends DAOFactory {
    @Override
    public CustomerDAO getUserDAO() throws DAOException {
        return new OracleCustomerDAO();
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
