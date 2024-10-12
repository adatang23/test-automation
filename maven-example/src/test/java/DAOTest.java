import database.db_third_topic.bank.constant.ProjectConstant;
import database.db_third_topic.bank.factory.DAOFactory;
import database.db_third_topic.bank.model.Customer;
import database.db_third_topic.bank.services.CustomerService;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.sql.SQLException;

public class DAOTest {
    private static final Customer CUSTOMER = new Customer() {
        {
            setUser_name("JamesSmith");
            setPassword("password123");
            setFirst_name("James");
            setLast_name("Smith");
            setPhone("4748995503");
            setEmail("james.smith@gmail.com");
            setRegistration_date("2024-10-08");
        }
    };

    @Test (priority = 0, description = "Create a customer")
    public void createCustomer() throws SQLException {
        //Create a DAOFactory instance for MySQL
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(ProjectConstant.MYSQL);
        CustomerService customerService = new CustomerService(mySQLFactory);
        System.out.println("DAOFactory successfully obtained: " + mySQLFactory);
        customerService.setSafeUpdates(0);
        customerService.deleteAllCustomers();
        customerService.setSafeUpdates(1);
        customerService.resetAutoIncrement();
        customerService.createCustomer(CUSTOMER);
        System.out.println("User successfully created: " + CUSTOMER);
        checkCustomer(customerService.getCustomer(CUSTOMER.getCustomer_id()));
    }

    private void checkCustomer(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER.getUser_name(), "User name must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER.getPassword(), "Password must match");
        Assert.assertEquals(customer.getEmail(), CUSTOMER.getEmail(), "Email must match");
    }

    @Test(priority = 1, description = "Select a customer with customer_id=1")
    public void readCustomer() throws SQLException {
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(ProjectConstant.MYSQL);
        CustomerService customerService = new CustomerService(mySQLFactory);
        System.out.println("DAOFactory successfully obtained: " + mySQLFactory);
        Customer customer = customerService.getCustomer(1);
        System.out.println("User successfully found, customer_id: " + customer.getCustomer_id()
                + " User name: " + customer.getUser_name());
    }

    @Test(priority = 2, description = "Update a customer's password with customer_id=1")
    public void updatePasswordCustomer() throws SQLException {
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(ProjectConstant.MYSQL);
        CustomerService customerService = new CustomerService(mySQLFactory);
        System.out.println("DAOFactory successfully obtained: " + mySQLFactory);
        Customer customer = customerService.getCustomer(1);
        String newPassword = "NewPassword";
        customerService.updatePassword(customer, newPassword);
        Customer updatedCustomer = customerService.getCustomer(1);
        Assert.assertEquals(updatedCustomer.getCustomer_id(), customer.getCustomer_id(), "Customer id must match");
        Assert.assertEquals(updatedCustomer.getUser_name(), customer.getUser_name(), "User name must match");
        Assert.assertEquals(updatedCustomer.getPassword(), newPassword, "Password must match");
    }

    @Test(priority = 3, description = "Delete a customer with customer_id=1")
    public void deleteCustomer() throws SQLException {
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(ProjectConstant.MYSQL);
        CustomerService customerService = new CustomerService(mySQLFactory);
        System.out.println("DAOFactory successfully obtained: " + mySQLFactory);
        Customer customer = customerService.getCustomer(1);
        customerService.deleteCustomer(customer);
        Customer deletedCustomer = customerService.getCustomer(1);
        if (deletedCustomer == null) {
            System.out.println("Successfully deleted customer with customer_id: " + customer.getCustomer_id());
        }
    }
}
