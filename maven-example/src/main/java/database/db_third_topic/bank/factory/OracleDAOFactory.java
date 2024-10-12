package database.db_third_topic.bank.factory;
import database.db_third_topic.bank.exception.DAOException;
import database.db_third_topic.bank.dao.jdbc.*;
import database.db_third_topic.bank.dao.CustomerDAO;

public class OracleDAOFactory extends DAOFactory {
    @Override
    public CustomerDAO getUserDAO() throws DAOException {
        return new OracleCustomerDAO();
    }
}
