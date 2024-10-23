package database.db_fifth_topic.bank.model;

public class AccountType {
    private Integer account_type_id;
    private String account_type_name;
    private Double interest_rate;

    public Integer getAccount_type_id() {
        return account_type_id;
    }

    public void setAccount_type_id(Integer account_type_id) {
        this.account_type_id = account_type_id;
    }

    public String getAccount_type_name() {
        return account_type_name;
    }

    public void setAccount_type_name(String account_type_name) {
        this.account_type_name = account_type_name;
    }

    public Double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(Double interest_rate) {
        this.interest_rate = interest_rate;
    }
}
