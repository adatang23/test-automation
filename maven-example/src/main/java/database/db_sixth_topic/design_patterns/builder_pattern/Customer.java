package database.db_sixth_topic.design_patterns.builder_pattern;

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

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    private Customer(CustomerBuilder builder) {
        this.customer_id = builder.customer_id;
        this.user_name = builder.user_name;
        this.password = builder.password;
        this.first_name = builder.first_name;
        this.last_name = builder.last_name;
        this.phone = builder.phone;
        this.email = builder.email;
        this.registration_date = builder.registration_date;
    }

    // Builder Class
    public static class CustomerBuilder {
        private Integer customer_id;
        private String user_name;
        private String password;
        private String first_name;
        private String last_name;
        private String phone;
        private String email;
        private String registration_date;

        public CustomerBuilder() {
        }

        public CustomerBuilder setCustomer_id(Integer customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public CustomerBuilder setUser_name(String user_name) {
            this.user_name = user_name;
            return this;
        }

        public CustomerBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomerBuilder setFirst_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public CustomerBuilder setLast_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public CustomerBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public CustomerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public CustomerBuilder setRegistration_date(String registration_date) {
            this.registration_date = registration_date;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
