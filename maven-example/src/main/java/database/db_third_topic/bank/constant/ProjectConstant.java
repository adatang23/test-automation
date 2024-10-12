package database.db_third_topic.bank.constant;

public class ProjectConstant {
    //Property Constants-----------------------
    public static final String PROPERTIES_FILE = "dao.properties";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_DRIVER = "driver";
    public static final String PROPERTY_USERNAME = "user";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_KEY_NAME = "mySQL";

    // CREATE of CRUD
    public static final String SQL_INSERT_CUSTOMER = "INSERT INTO Customer (user_name, " +
            "password, first_name, last_name, phone, email, registration_date) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";

    // SELECT/READ of CRUD
    public static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM Customer WHERE customer_id = ?;";
    public static final String SQL_FIND_BY_EMAIL = "SELECT * FROM Customer WHERE email = ?;";

    // UPDATE of CRUD
    public static final String SQL_UPDATE_CUSTOMER_PASSWORD = "UPDATE Customer SET password = ? WHERE customer_id = ?;";

    // DELETE of CRUD
    public static final String SQL_DELETE_CUSTOMER = "DELETE FROM Customer WHERE customer_id = ?;";

    // Clear Table and reset AUTO_INCREMENT;
    public static final String SQL_SET_SAFE_UPDATES_CUSTOMER = "SET SQL_SAFE_UPDATES = ?;";
    public static final String SQL_DELETE_ALL_CUSTOMER = "DELETE FROM Customer;";
    public static final String SQL_RESET_AUTO_INCREMENT_CUSTOMER = "ALTER TABLE Customer AUTO_INCREMENT= ?;";

    // List of DAO type supported by the factory----------------------
    public static final int ORACLE = 1;
    public static final int MYSQL = 2;
    public static final int POSTGRESQL = 3;

}
