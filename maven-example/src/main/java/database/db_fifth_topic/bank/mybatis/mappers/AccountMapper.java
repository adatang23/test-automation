package database.db_fifth_topic.bank.mybatis.mappers;
import database.db_fifth_topic.bank.mybatis.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {
    void create(Account account);

    Account findById(Integer id);

    void updateBalance(@Param("a") Double balance, @Param("b") Integer account_id);

    void resetAutoIncrement();

    void setSafeUpdates(Integer n);

    void deleteAllAccounts();

    void deleteAccount(Account account);
}
