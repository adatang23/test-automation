import database.db_fifth_topic.bank.mybatis.model.*;
import database.db_fifth_topic.bank.mybatis.service.BranchService;
import database.db_fifth_topic.bank.mybatis.service.CustomerService;
import database.db_sixth_topic.design_patterns.abstract_factory_pattern.AbstractFactory;
import database.db_sixth_topic.design_patterns.abstract_factory_pattern.FactoryGenerator;
import database.db_sixth_topic.design_patterns.abstract_factory_pattern.*;
import database.db_sixth_topic.design_patterns.factory_pattern.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DesignPatternsTest {
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

    private static final AccountType ACCOUNT_TYPE_1 = new AccountType() {
        {
            setAccount_type_name("Checking");
            setInterest_rate(0.01);
        }
    };

    // Factory Pattern, CreateCustomer
    @Test(priority = 0, description = "Create a Customer1")
    public void createCustomerTest01() {
        CreateCustomer createCustomer = new CreateCustomer();
        CustomerService customerService = new CustomerService();
        customerService.setSafeUpdates(0);
        customerService.deleteAllCustomers();
        customerService.resetAutoIncrement();
        customerService.setSafeUpdates(1);
        createCustomer.createObject((Customer) CUSTOMER_1);
        Customer customer = customerService.getCustomer(CUSTOMER_1.getCustomer_id());
        System.out.println("Customer successfully created: " + customer.getUser_name());
        checkCustomer1(customer);
    }

    private void checkCustomer1(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER_1.getUser_name(), "UserName must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER_1.getPassword(), "Password must match");
    }

    // Abstract Factory Pattern, CreatePerson
    @Test(priority = 1, description = "Create a Customer2")
    public void createCustomerTest02() {
        AbstractFactory personFactory = FactoryGenerator.getFactory("Person");
        CustomerService customerService = new CustomerService();
        CreatePerson person = personFactory.getPerson("Customer");
        person.createPerson(CUSTOMER_2);
        Customer customer = customerService.getCustomer(CUSTOMER_2.getCustomer_id());
        System.out.println("Customer successfully created: " + customer.getUser_name());
        checkCustomer2(customer);
    }

    private void checkCustomer2(Customer customer) {
        Assert.assertEquals(customer.getUser_name(), CUSTOMER_2.getUser_name(), "UserName must match");
        Assert.assertEquals(customer.getPassword(), CUSTOMER_2.getPassword(), "Password must match");
    }

    // Factory Pattern, CreateBranch
    @Test(priority = 2, description = "Create a Branch1")
    public void createBranchTest02() {
        CreateBranch createBranch = new CreateBranch();
        BranchService branchService = new BranchService();
        branchService.setSafeUpdates(0);
        branchService.deleteAllBranches();
        branchService.resetAutoIncrement();
        branchService.setSafeUpdates(1);
        createBranch.createObject((Branch) BRANCH_1);
        Branch branch = branchService.getBranch(BRANCH_1.getBranch_id());
        System.out.println("Customer successfully created: " + branch.getBranch_name());
        checkBranch1(branch);
    }

    private void checkBranch1(Branch branch) {
        Assert.assertEquals(branch.getBranch_name(), BRANCH_1.getBranch_name(), "Branch name must match");
        Assert.assertEquals(branch.getPhone(), BRANCH_1.getPhone(), "Branch phone must match");
    }

    // Abstract Factory Pattern, CreateFacility
    @Test(priority = 3, description = "Create a Branch2")
    public void createBranchTest03() {
        AbstractFactory facilityFactory = FactoryGenerator.getFactory("Facility");
        BranchService branchService = new BranchService();
        CreateFacility facility = facilityFactory.getFacility("Branch");
        facility.createFacility(BRANCH_2);
        Branch branch = branchService.getBranch(BRANCH_2.getBranch_id());
        System.out.println("Customer successfully created: " + branch.getBranch_name());
        checkBranch2(branch);
    }

    private void checkBranch2(Branch branch) {
        Assert.assertEquals(branch.getBranch_name(), BRANCH_2.getBranch_name(), "Branch name must match");
        Assert.assertEquals(branch.getPhone(), BRANCH_2.getPhone(), "Branch phone must match");
    }
}
