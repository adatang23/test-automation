package database.db_fifth_topic.bank.mybatis.mappers;

import database.db_fifth_topic.bank.mybatis.model.AccountType;

public interface AccountTypeMapper {
    void create(AccountType accountType);

    AccountType findById(Integer id);

    void resetAutoIncrement();

    void setSafeUpdates(Integer n);

    void deleteAllAccountTypes();

    void deleteAccountType(AccountType accountType);
}
