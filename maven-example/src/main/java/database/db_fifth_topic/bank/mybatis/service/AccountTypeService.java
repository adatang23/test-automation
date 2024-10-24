package database.db_fifth_topic.bank.mybatis.service;
import database.db_fifth_topic.bank.mybatis.mappers.AccountTypeMapper;
import database.db_fifth_topic.bank.mybatis.model.AccountType;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountTypeService {
    public void create(AccountType accountType) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            accountTypeMapper.create(accountType);
        }
    }

    public AccountType getAccountType(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            return accountTypeMapper.findById(id);
        }
    }

    public void setSafeUpdates(Integer n) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            accountTypeMapper.setSafeUpdates(n);
        }
    }

    public void resetAutoIncrement() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            accountTypeMapper.resetAutoIncrement();
        }
    }

    public void deleteAccountType(AccountType accountType) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            Integer account_type_id = accountType.getAccount_type_id();
            if (account_type_id != null && accountTypeMapper.findById(account_type_id) != null) {
                accountTypeMapper.deleteAccountType(accountType);
            } else {
                System.out.println("The account_type_id is not in the table.");
            }
        }
    }

    public void deleteAllAccountTypes() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountTypeMapper accountTypeMapper = sqlSession.getMapper(AccountTypeMapper.class);
            accountTypeMapper.deleteAllAccountTypes();
        }
    }
}
