package database.db_third_topic.bank.model;

public class Branch {
    private Integer branch_id;
    private String branch_name;
    private String address;
    private String phone;

    public Integer getBranchId() {
        return branch_id;
    }

    public void setBranchId(Integer branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranchName() {
        return branch_name;
    }

    public void setBranchName(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) { this.phone = phone; }
}
