import database.db_fifth_topic.bank.mybatis.model.*;
import database.db_fifth_topic.bank.mybatis.service.BranchService;
import database.db_sixth_topic.solid_principles.interface_segregation.CustomerUpdate;
import database.db_sixth_topic.solid_principles.liskov.BranchListImpl;
import database.db_sixth_topic.solid_principles.liskov.CustomerListImpl;
import database.db_sixth_topic.solid_principles.single_responsibility.mybatis.service.*;
import database.db_sixth_topic.solid_principles.open_closed.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SolidPrinciplesTest {

    private static final Customer CUSTOMER_1 = new Customer() {
        {
            setUser_name("JamesSmith");
            setPassword("password123");
            setFirst_name("James");
            setLast_name("Smith");
            setPhone("4748995503");
            setEmail("james.smith@gmail.com");
            setRegistration_date("2010-02-01");
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

    private static final Customer CUSTOMER_3 = new Customer() {
        {
            setUser_name("MichaelWilliams");
            setPassword("password789");
            setFirst_name("Michael");
            setLast_name("Williams");
            setPhone("3077018838");
            setEmail("michael.williams@gmail.com");
            setRegistration_date("2012-08-30");
        }
    };

    private static final Branch BRANCH_1 = new Branch() {
        {
            setBranch_name("Branch01");
            setAddress("108N Belair Rd, Evans, Georgia, 30809");
            setPhone("7068550483");
        }
    };

    private static final Branch BRANCH_2 = new Branch() {
        {
            setBranch_name("Branch02");
            setAddress("9 Hartford Ave, West Springfield, MA 01089");
            setPhone("2535112433");
        }
    };


    // Single responsibility principle
    @Test(priority = 0, description = "Create a Customer1")
    public void createCustomerTest01() {
        CustomerCreateService customerCreateService = new CustomerCreateService();
        CustomerSelectService customerSelectService = new CustomerSelectService();
        CustomerUpdateService customerUpdateService = new CustomerUpdateService();
        CustomerDeleteService customerDeleteService = new CustomerDeleteService();
        customerUpdateService.setSafeUpdates(0);
        customerDeleteService.deleteAllCustomers();
        customerUpdateService.resetAutoIncrement();
        customerUpdateService.setSafeUpdates(1);
        customerCreateService.create(CUSTOMER_1);
        System.out.println("Customer successfully created: " + CUSTOMER_1.getUser_name());
        checkCustomer01(customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id()));
    }

    private void checkCustomer01(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER_1.getUser_name(), "UserName must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER_1.getPassword(), "Password must match");
    }

    // Open closed principle, CustomerCreate
    @Test(priority = 1, description = "Create a Customer2")
    public void createCustomerTest02() {
        CustomerCreate customerCreate = new CustomerCreate();
        CustomerSelectService customerSelectService = new CustomerSelectService();
        customerCreate.create(CUSTOMER_2);
        System.out.println("Customer successfully created: " + CUSTOMER_2.getUser_name());
        checkCustomer02(customerSelectService.getCustomer(CUSTOMER_2.getCustomer_id()));
    }

    private void checkCustomer02(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER_2.getUser_name(), "UserName must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER_2.getPassword(), "Password must match");
    }

    // Liskov principle, CustomerListImpl
    @Test(priority = 2, description = "Create a Customer3")
    public void createCustomerTest03() {
        CustomerListImpl customerList = new CustomerListImpl();
        customerList.add(CUSTOMER_3);
        Customer customer = (Customer) customerList.get(CUSTOMER_3.getCustomer_id());
        System.out.println("Customer successfully created: " + customer.getUser_name());
        System.out.println("The customerList size: " + customerList.size());
        checkCustomer03(customer);
    }

    private void checkCustomer03(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER_3.getUser_name(), "UserName must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER_3.getPassword(), "Password must match");
    }


    // Open closed principle, BranchCreate
    @Test(priority = 3, description = "Create a Branch")
    public void createBranchTest03() {
        BranchCreate branchCreate = new BranchCreate();
        BranchService branchService = new BranchService();
        branchService.setSafeUpdates(0);
        branchService.deleteAllBranches();
        branchService.resetAutoIncrement();
        branchService.setSafeUpdates(1);
        branchCreate.create(BRANCH_1);
        System.out.println("Branch successfully created: " + BRANCH_1.getBranch_name());
        checkBranch01(branchService.getBranch(BRANCH_1.getBranch_id()));
    }

    private void checkBranch01(Branch branch) {
        Assert.assertEquals(branch.getBranch_name(), BRANCH_1.getBranch_name(), "BranchName must match");
        Assert.assertEquals(branch.getPhone(), BRANCH_1.getPhone(), "Phone must match");
    }

    // Liskov principle, BranchListImpl
    @Test(priority = 4, description = "Create a Branch")
    public void createBranchTest04() {
        BranchListImpl branchList = new BranchListImpl();
        branchList.add(BRANCH_2);
        Branch branch = (Branch) branchList.get(BRANCH_2.getBranch_id());
        System.out.println("Branch successfully created: " + branch.getBranch_name());
        System.out.println("The branchList size: " + branchList.size());
        checkBranch02(branch);
    }

    private void checkBranch02(Branch branch) {
        Assert.assertEquals(branch.getBranch_name(), BRANCH_2.getBranch_name(), "BranchName must match");
        Assert.assertEquals(branch.getPhone(), BRANCH_2.getPhone(), "Phone must match");
    }



    // Single responsibility principle
    @Test(priority = 6, description = "Select the Customer1")
    public void selectCustomerTest07() {
        CustomerSelectService customerSelectService = new CustomerSelectService();
        Customer customer = customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id());
        System.out.println("Customer successfully found, customer_id: " + customer.getCustomer_id()
                + " Customer name: " + customer.getUser_name());
    }


    // Interface segregation principle, CustomerUpdate
    @Test(priority = 10, description = "Update the Customer1's password")
    public void updateCustomerPasswordTest11() {
        CustomerUpdate customerUpdate = new CustomerUpdate();
        CustomerSelectService customerSelectService = new CustomerSelectService();
        Customer customer = customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id());
        String newPassword = "NewPassword";
        customerUpdate.updatePassword(newPassword, CUSTOMER_1.getCustomer_id());
        Customer updatedCustomer = customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id());
        Assert.assertEquals(updatedCustomer.getCustomer_id(), customer.getCustomer_id(),
                "Customer id must match");
        Assert.assertEquals(updatedCustomer.getUser_name(), customer.getUser_name(),
                "User name must match");
        Assert.assertEquals(updatedCustomer.getPassword(), newPassword,
                "Password must match");
    }



    /*
    // Single responsibility principle
    @Test(priority = 10, description = "Update the Customer1's password")
    public void updateCustomerPasswordTest11() {
        CustomerUpdateService customerUpdateService = new CustomerUpdateService();
        CustomerSelectService customerSelectService = new CustomerSelectService();
        Customer customer = customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id());
        String newPassword = "NewPassword";
        customerUpdateService.updatePassword(newPassword, CUSTOMER_1.getCustomer_id());
        Customer updatedCustomer = customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id());
        Assert.assertEquals(updatedCustomer.getCustomer_id(), customer.getCustomer_id(),
                "Customer id must match");
        Assert.assertEquals(updatedCustomer.getUser_name(), customer.getUser_name(),
                "User name must match");
        Assert.assertEquals(updatedCustomer.getPassword(), newPassword,
                "Password must match");
    } */


    // Single responsibility principle
    @Test(priority = 15, description = "Delete the Customer1")
    public void deleteCustomerTest16() {
        CustomerSelectService customerSelectService = new CustomerSelectService();
        CustomerDeleteService customerDeleteService = new CustomerDeleteService();
        Customer customer = customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id());
        customerDeleteService.deleteCustomer(customer);
        Customer deletedCustomer = customerSelectService.getCustomer(CUSTOMER_1.getCustomer_id());
        if (deletedCustomer == null) {
            System.out.println("Successfully deleted customer with customer_id: " + customer.getCustomer_id());
        }
    }

    // Single responsibility principle
    @Test(priority = 16, description = "Delete the Customer2")
    public void deleteCustomerTest17() {
        CustomerSelectService customerSelectService = new CustomerSelectService();
        CustomerDeleteService customerDeleteService = new CustomerDeleteService();
        Customer customer = customerSelectService.getCustomer(CUSTOMER_2.getCustomer_id());
        customerDeleteService.deleteCustomer(customer);
        Customer deletedCustomer = customerSelectService.getCustomer(CUSTOMER_2.getCustomer_id());
        if (deletedCustomer == null) {
            System.out.println("Successfully deleted customer with customer_id: " + customer.getCustomer_id());
        }
    }
}
