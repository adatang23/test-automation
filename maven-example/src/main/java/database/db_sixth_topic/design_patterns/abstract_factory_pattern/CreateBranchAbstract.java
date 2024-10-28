package database.db_sixth_topic.design_patterns.abstract_factory_pattern;
import database.db_fifth_topic.bank.mybatis.mappers.BranchMapper;
import database.db_fifth_topic.bank.mybatis.model.Branch;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class CreateBranchAbstract<T> implements CreateFacility<T> {
    @Override
    public void createFacility(T element) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            BranchMapper branchMapper = sqlSession.getMapper(BranchMapper.class);
            branchMapper.create((Branch) element);
        }
    }
}
