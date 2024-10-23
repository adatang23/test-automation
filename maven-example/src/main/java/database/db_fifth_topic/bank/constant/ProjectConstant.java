package database.db_fifth_topic.bank.constant;

public class ProjectConstant {
    //Property Constants-----------------------
    public static final String PROPERTIES_FILE = "dao.properties";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_DRIVER = "driver";
    public static final String PROPERTY_USERNAME = "user";
    public static final String PROPERTY_PASSWORD = "password";
    public static final String PROPERTY_KEY_NAME = "mySQL";


    // CREATE of CRUD
    public static final String SQL_INSERT_CUSTOMER = "INSERT INTO Customer "
            + "(user_name, password, first_name, last_name, phone, email, registration_date) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?);";
    public static final String SQL_INSERT_BRANCH = "INSERT INTO Branch (branch_name, address, phone) VALUES (?, ?, ?);";
    public static final String SQL_INSERT_ACCOUNT_TYPE = "INSERT INTO AccountType "
            + "(account_type_name, interest_rate) VALUES (?, ?);";
    public static final String SQL_INSERT_ACCOUNT = "INSERT INTO Account " +
            "(user_id, account_opened, type_id, balance, branch_id) VALUES (?, ?, ?, ?, ?);";


    // SELECT/READ of CRUD
    public static final String SQL_FIND_BY_CUSTOMER_ID = "SELECT * FROM Customer WHERE customer_id = ?;";
    public static final String SQL_FIND_BY_ACCOUNT_TYPE_ID = "SELECT * FROM AccountType WHERE account_type_id = ?;";
    public static final String SQL_FIND_BY_ACCOUNT_ID = "SELECT * FROM Account WHERE account_id = ?;";
    public static final String SQL_FIND_BY_BRANCH_ID = "SELECT * FROM Branch WHERE branch_id = ?;";


    // UPDATE of CRUD
    public static final String SQL_UPDATE_CUSTOMER_PASSWORD = "UPDATE Customer SET password = ? WHERE customer_id = ?;";
    public static final String SQL_UPDATE_ACCOUNT_BALANCE = "UPDATE Account SET balance = ? WHERE account_id = ?;";
    public static final String SQL_UPDATE_BRANCH_PHONE = "UPDATE Branch SET phone = ? WHERE branch_id = ?;";


    // DELETE of CRUD
    public static final String SQL_DELETE_CUSTOMER = "DELETE FROM Customer WHERE customer_id = ?;";
    public static final String SQL_DELETE_ACCOUNT_TYPE = "DELETE FROM AccountType WHERE account_type_id = ?;";
    public static final String SQL_DELETE_ACCOUNT = "DELETE FROM Account WHERE account_id = ?;";
    public static final String SQL_DELETE_BRANCH = "DELETE FROM Branch WHERE branch_id = ?;";


    // Clear Table and reset AUTO_INCREMENT;
    public static final String SQL_SET_SAFE_UPDATES = "SET SQL_SAFE_UPDATES = ?;";
    public static final String SQL_DELETE_ALL_CUSTOMER = "DELETE FROM Customer;";
    public static final String SQL_RESET_AUTO_INCREMENT_CUSTOMER = "ALTER TABLE Customer AUTO_INCREMENT= ?;";
    public static final String SQL_DELETE_ALL_ACCOUNT_TYPE = "DELETE FROM AccountType;";
    public static final String SQL_RESET_AUTO_INCREMENT_ACCOUNT_TYPE = "ALTER TABLE AccountType AUTO_INCREMENT= ?;";
    public static final String SQL_DELETE_ALL_ACCOUNT = "DELETE FROM Account;";
    public static final String SQL_RESET_AUTO_INCREMENT_ACCOUNT = "ALTER TABLE Account AUTO_INCREMENT= ?;";
    public static final String SQL_DELETE_ALL_BRANCH = "DELETE FROM Branch;";
    public static final String SQL_RESET_AUTO_INCREMENT_BRANCH = "ALTER TABLE Branch AUTO_INCREMENT= ?;";


    // List of DAO type supported by the factory----------------------
    public static final int ORACLE = 1;
    public static final int MYSQL = 2;
    public static final int POSTGRESQL = 3;

}
