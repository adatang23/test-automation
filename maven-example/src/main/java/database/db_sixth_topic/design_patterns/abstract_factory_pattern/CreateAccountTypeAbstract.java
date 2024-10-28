package database.db_sixth_topic.design_patterns.abstract_factory_pattern;
import database.db_fifth_topic.bank.mybatis.mappers.AccountTypeMapper;
import database.db_fifth_topic.bank.mybatis.model.AccountType;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class CreateAccountTypeAbstract<T> implements CreateFacility<T> {
    @Override
    public void createFacility(T element) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            accountTypeMapper.create((AccountType) element);
        }
    }
}
