package database.db_sixth_topic.solid_principles.interface_segregation;
import database.db_fifth_topic.bank.mybatis.mappers.BranchMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


/**
 * Interface Segregation principle:
 * A client should never be forced to implement an interface that it doesn't use,
 * or clients shouldn't be forced to depend on methods they do not use.
 * Only the classes need the method will implement the interface.
 */

public class BranchUpdate implements UpdatePhone {
    @Override
    public void updatePhone(String phone, Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.updatePhone(phone, id);
        }
    }
}
