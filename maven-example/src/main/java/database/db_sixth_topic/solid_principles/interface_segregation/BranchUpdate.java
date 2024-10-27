package database.db_sixth_topic.solid_principles.interface_segregation;
import database.db_fifth_topic.bank.mybatis.mappers.BranchMapper;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class BranchUpdate implements UpdatePhone {
    @Override
    public void updatePhone(String phone, Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.updatePhone(phone, id);
        }
    }
}
