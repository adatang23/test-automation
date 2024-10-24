package database.db_fifth_topic.bank.mybatis.service;
import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


public class CustomerService {
    public void create(Customer customer) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.create(customer);
        }
    }

    public Customer getCustomer(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            return customerMapper.findById(id);
        }
    }

    public void updatePassword(String password, Integer customer_id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.updatePassword(password, customer_id);
        }
    }

    public void setSafeUpdates(Integer n) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.setSafeUpdates(n);
        }
    }

    public void resetAutoIncrement() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.resetAutoIncrement();
        }
    }

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
