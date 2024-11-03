package projects.first_topic.smart_bank_app.model;

public class Transaction {
    private Integer transaction_id;
    private String transaction_type;
    private double transaction_amount;
    private String transaction_date;
    private Integer from_account_id;
    private Integer to_account_id;

    public Transaction() {
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Integer getFrom_account_id() {
        return from_account_id;
    }

    public void setFrom_account_id(Integer from_account_id) {
        this.from_account_id = from_account_id;
    }

    public Integer getTo_account_id() {
        return to_account_id;
    }

    public void setTo_account_id(Integer to_account_id) {
        this.to_account_id = to_account_id;
    }
}
