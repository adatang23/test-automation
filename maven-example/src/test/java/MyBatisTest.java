import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.service.CustomerService;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyBatisTest {
    private static final Customer CUSTOMER_1 = new Customer() {
        {
            setUser_name("JamesSmith");
            setPassword("password123");
            setFirst_name("James");
            setLast_name("Smith");
            setPhone("4748995503");
            setEmail("james.smith@gmail.com");
            setRegistration_date("2020-06-20");
        }
    };

    private static final Customer CUSTOMER_2 = new Customer() {
        {
            setUser_name("MaryJohnson");
            setPassword("password456");
            setFirst_name("Mary");
            setLast_name("Johnson");
            setPhone("6234213337");
            setEmail("mary.johnson@yahoo.com");
            setRegistration_date("2011-06-10");
        }
    };

    // Create of CRUD
    @Test(priority = 0, description = "Create a Customer1")
    public void createCustomerTest01() {
        CustomerService customerService = new CustomerService();
        customerService.setSafeUpdates(0);
        customerService.deleteAllCustomers();
        customerService.resetAutoIncrement();
        customerService.setSafeUpdates(1);
        customerService.create(CUSTOMER_1);
        checkCustomer01(customerService.getCustomer(CUSTOMER_1.getCustomer_id()));
    }

    private void checkCustomer01(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER_1.getUser_name(), "UserName must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER_1.getPassword(), "Password must match");
    }

    // Create of CRUD
    @Test(priority = 1, description = "Create a Customer2")
    public void createCustomerTest02() {
        CustomerService customerService = new CustomerService();
        customerService.create(CUSTOMER_2);
        checkCustomer02(customerService.getCustomer(CUSTOMER_2.getCustomer_id()));
    }

    private void checkCustomer02(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER_2.getUser_name(), "UserName must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER_2.getPassword(), "Password must match");
    }

    // Read/Select of CRUD
    @Test(priority = 2, description = "Select the Customer1")
    public void selectCustomerTest03() {
        CustomerService customerService = new CustomerService();
        customerService.getCustomer(CUSTOMER_1.getCustomer_id());
    }

    // Update of CRUD
    @Test(priority = 3, description = "Update the Customer1's password")
    public void updateCustomerPasswordTest04() {
        CustomerService customerService = new CustomerService();
        customerService.updatePassword("pwd789", CUSTOMER_1.getCustomer_id());
    }

    // Delete of CRUD
    @Test(priority = 4, description = "Delete the Customer1.")
    public void deleteCustomerTest05() {
        CustomerService customerService = new CustomerService();
        customerService.deleteCustomer(CUSTOMER_1);
    }

    // Delete all of CRUD
    @Test(priority = 5, description = "Delete all customers.")
    public void deleteAllCustomerTest06() {
        CustomerService customerService = new CustomerService();
        customerService.setSafeUpdates(0);
        customerService.deleteAllCustomers();
        customerService.resetAutoIncrement();
        customerService.setSafeUpdates(1);
    }
}
