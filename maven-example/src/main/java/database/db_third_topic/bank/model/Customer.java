package database.db_third_topic.bank.model;

public class Customer {
    private Integer customer_id;
    private String user_name;
    private String password;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String registration_date;

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    /**
     * The customer_id is unique for each Customer.
     * So this should compare Customer by customer_id only.
     */

    @Override
    public boolean equals(Object other) {
        return (other instanceof Customer) && (customer_id != null)
                ? customer_id.equals(((Customer) other).customer_id) : (other == this);
    }
}
