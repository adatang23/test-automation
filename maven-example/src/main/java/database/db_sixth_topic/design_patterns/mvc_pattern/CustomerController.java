package database.db_sixth_topic.design_patterns.mvc_pattern;
import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * MVC Pattern:
 * The MVC design pattern is a software architecture pattern that separates an application into
 * three main components: Model, View, and Controller, making it easier to manage and maintain the codebase.
 * It also allows for the reusability of components and promotes a more modular approach to software development.
 * Model: Customer, View: CustomerView, Controller: CustomerController
 */

public class CustomerController {
    private Customer model;
    private CustomerView view;

    public CustomerController(Customer model, CustomerView view) {
        this.model = model;
        this.view = view;
    }

    public void setUserName(String userName) {
        model.setUser_name(userName);
    }

    public String getUserName() {
        return model.getUser_name();
    }

    public void setPhone(String phone) {
        model.setPhone(phone);
    }

    public String getPhone() {
        return model.getPhone();
    }

    public void setEmail(String email) {
        model.setEmail(email);
    }

    public String getEmail() {
        return model.getEmail();
    }

    public void updateInformation() {
        view.printCustomerDetails(model.getUser_name(), model.getPhone(), model.getEmail());
        Integer id = model.getCustomer_id();
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.updateUserName(model.getUser_name(), id);
            customerMapper.updatePhone(model.getPhone(), id);
            customerMapper.updateEmail(model.getEmail(), id);
        }
    }
}
