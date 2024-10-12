package database.db_third_topic.bank.factory;
import database.db_third_topic.bank.dao.CustomerDAO;
import database.db_third_topic.bank.dao.jdbc.PostgreSQLCustomerDAO;
import database.db_third_topic.bank.exception.DAOException;

public class PostgreSQLDAOFactory extends DAOFactory {
    @Override
    public CustomerDAO getUserDAO() throws DAOException {
        return new PostgreSQLCustomerDAO();
    }
}
