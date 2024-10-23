package database.db_fifth_topic.bank.mybatis.mappers;
import database.db_fifth_topic.bank.mybatis.model.Account;


public interface AccountMapper {
    void create(Account account);

    Account findById(Integer id);

    void resetAutoIncrement();

    void setSafeUpdates(Integer n);

    void deleteAllAccounts();

    void deleteAccount(Account account);
}
