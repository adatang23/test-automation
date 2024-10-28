package database.db_sixth_topic.solid_principles.dependency_inversion;
import database.db_fifth_topic.bank.mybatis.mappers.AccountTypeMapper;
import database.db_fifth_topic.bank.mybatis.model.AccountType;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


public class AccountTypeCreateService {
    public void create(AccountType accountType) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            accountTypeMapper.create(accountType);
        }
    }
}
