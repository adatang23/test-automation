package database.db_fifth_topic.bank.mybatis.service;
import database.db_fifth_topic.bank.mybatis.mappers.AccountMapper;
import database.db_fifth_topic.bank.mybatis.model.Account;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class AccountService {
    public void create(Account account) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.create(account);
        }
    }

    public Account getAccount(Integer id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            return accountMapper.findById(id);
        }
    }

    public void updateBalance(Double balance, Integer account_id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.updateBalance(balance, account_id);
        }
    }

    public void setSafeUpdates(Integer n) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.setSafeUpdates(n);
        }
    }

    public void resetAutoIncrement() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.resetAutoIncrement();
        }
    }

    public void deleteAccount(Account account) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            Integer account_id = account.getAccount_id();
            if (account_id != null && accountMapper.findById(account_id) != null) {
                accountMapper.deleteAccount(account);
            } else {
                System.out.println("The account_id is not in the table.");
            }
        }
    }

    public void deleteAllAccounts() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
            accountMapper.deleteAllAccounts();
        }
    }
}
