package database.db_sixth_topic.design_patterns.proxy_pattern;

import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class RealOperationsPerformed implements OperationsPerformed {
    @Override
    public void view(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = customerMapper.findById(id);
            if (customer != null) {
                System.out.println("Customer's name: " + customer.getUser_name() + '\n'
                        + "Customer's phone: " + customer.getPhone() + '\n'
                        + "Customer's email: " + customer.getEmail());
            } else {
                System.out.println("The customer is not in the table.");
            }
        }
    }

    @Override
    public void edit(String phone, Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.updatePhone(phone, id);
        }
    }
}
