package database.db_sixth_topic.solid_principles.single_responsibility.mybatis.service;
import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Single Responsibility principle:
 * A class should have only one reason to change, meaning it should only have one responsibility.
 * CustomerDeleteService class only have one responsibility to delete customers.
 */

public class CustomerDeleteService {
    public void deleteCustomer(Customer customer) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            Integer customer_id = customer.getCustomer_id();
            if (customer_id != null && customerMapper.findById(customer_id) != null) {
                customerMapper.deleteCustomer(customer);
            } else {
                System.out.println("The customer_id is not in the table.");
            }
        }
    }

    public void deleteAllCustomers() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.deleteAllCustomers();
        }
    }
}
