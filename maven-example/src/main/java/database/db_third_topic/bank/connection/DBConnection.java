package database.db_third_topic.bank.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import database.db_third_topic.bank.util.DAOProperties;
import static database.db_third_topic.bank.constant.ProjectConstant.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    static Logger logger = LogManager.getLogger(DBConnection.class.getName());
    private static DBConnection instance;
    DAOProperties properties = new DAOProperties(PROPERTY_KEY_NAME);
    private final String url = properties.getProperty(PROPERTY_URL, true);
    private final String password = properties.getProperty(PROPERTY_PASSWORD, false);
    private final String userName = properties.getProperty(PROPERTY_USERNAME, password != null);

    private DBConnection() {
        try {
            String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
            //System.out.println("Connection ------ NEW DBConnection created");
            logger.info("Connection ------ NEW DBConnection created");
        }
        return DriverManager.getConnection(instance.url, instance.userName, instance.password);
    }
}