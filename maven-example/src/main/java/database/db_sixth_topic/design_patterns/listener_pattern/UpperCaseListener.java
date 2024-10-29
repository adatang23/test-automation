package database.db_sixth_topic.design_patterns.listener_pattern;

import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UpperCaseListener extends Listener {
    public UpperCaseListener(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            customerMapper.updatePassword(subject.getState().toUpperCase(), id);
        }
    }
}
