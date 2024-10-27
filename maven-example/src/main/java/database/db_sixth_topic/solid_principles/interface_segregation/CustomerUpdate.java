package database.db_sixth_topic.solid_principles.interface_segregation;

import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class CustomerUpdate implements UpdatePhone, UpdatePassword {

    @Override
    public void updatePassword(String password, Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.updatePassword(password, id);
        }
    }

    @Override
    public void updatePhone(String phone, Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.updatePassword(phone, id);
        }
    }
}
