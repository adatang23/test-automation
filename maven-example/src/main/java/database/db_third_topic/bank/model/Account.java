package database.db_third_topic.bank.model;

public class Account {
    private Integer account_id;
    private Integer user_id;
    private String account_opened;
    private Integer type_id;
    private Double balance;
    private Integer branch_id;

    public Integer getAccountId() {
        return account_id;
    }

    public void setAccountId(Integer account_id) {
        this.account_id = account_id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAccountOpened() {
        return account_opened;
    }

    public void setAccountOpened(String account_opened) {
        this.account_opened = account_opened;
    }

    public Integer getTypeId() {
        return type_id;
    }

    public void setTypeId(Integer type_id) {
        this.type_id = type_id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getBranchId() {
        return branch_id;
    }

    public void setBranchId(Integer branch_id) {
        this.branch_id = branch_id;
    }
}
