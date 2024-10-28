package database.db_sixth_topic.solid_principles.single_responsibility.mybatis.service;
import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Single Responsibility principle:
 * A class should have only one reason to change, meaning it should only have one responsibility.
 * CustomerCreateService class only have one responsibility to update customers.
 */

public class CustomerUpdateService {
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
}
