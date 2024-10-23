package database.db_fifth_topic.bank.mybatis.model;

public class Account {
    private Integer account_id;
    private Integer user_id;
    private String account_opened;
    private Integer type_id;
    private Double balance;
    private Integer branch_id;

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAccount_opened() {
        return account_opened;
    }

    public void setAccount_opened(String account_opened) {
        this.account_opened = account_opened;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Integer branch_id) {
        this.branch_id = branch_id;
    }
}
