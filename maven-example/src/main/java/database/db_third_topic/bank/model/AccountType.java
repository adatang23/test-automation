package database.db_third_topic.bank.model;

public class AccountType {
    private Integer account_type_id;
    private String account_type_name;
    private Double interest_rate;

    public Integer getAccountTypeId() {
        return account_type_id;
    }

    public void setAccountTypeId(Integer account_type_id) {
        this.account_type_id = account_type_id;
    }

    public String getAccountTypeName() {
        return account_type_name;
    }

    public void setAccountTypeName(String account_type_name) {
        this.account_type_name = account_type_name;
    }

    public Double getInterestRate() {
        return interest_rate;
    }

    public void setInterestRate(Double interest_rate) {
        this.interest_rate = interest_rate;
    }
}
