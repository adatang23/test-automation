package database.db_sixth_topic.solid_principles.single_responsibility.mybatis.service;
import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Single Responsibility principle:
 * A class should have only one reason to change, meaning it should only have one responsibility.
 * CustomerCreateService class only have one responsibility to create customers.
 */

public class CustomerCreateService {
    public void create(Customer customer) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.create(customer);
        }
    }
}
