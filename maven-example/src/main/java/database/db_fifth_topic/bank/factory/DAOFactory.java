package database.db_fifth_topic.bank.factory;
import database.db_fifth_topic.bank.dao.AccountTypeDAO;
import database.db_fifth_topic.bank.dao.BranchDAO;
import database.db_fifth_topic.bank.dao.CustomerDAO;
import database.db_fifth_topic.bank.dao.AccountDAO;
import database.db_fifth_topic.bank.exception.*;
import static database.db_fifth_topic.bank.constant.ProjectConstant.*;


public abstract class DAOFactory {
    public abstract CustomerDAO getUserDAO() throws DAOException;
    public abstract AccountTypeDAO getAccountTypeDAO() throws DAOException;
    public abstract BranchDAO getBranchDAO() throws DAOException;
    public abstract AccountDAO getAccountDAO() throws DAOException;

    public static database.db_fifth_topic.bank.factory.DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case ORACLE:
                return new OracleDAOFactory();
            case MYSQL:
                return new MySQLDAOFactory();
            case POSTGRESQL:
                return new PostgreSQLDAOFactory();
            default:
                return null;
        }
    }
}
