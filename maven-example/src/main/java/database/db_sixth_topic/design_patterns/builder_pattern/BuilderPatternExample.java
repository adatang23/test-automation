package database.db_sixth_topic.design_patterns.builder_pattern;

/**
 * Builder Pattern:
 * Builder pattern builds a complex object using simple objects and using a step-by-step approach.
 * This type of design pattern comes under creational pattern as this pattern provides
 * one of the best ways to create an object.
 */

public class BuilderPatternExample {
    public static void main(String[] args) {
        // Creating a product using the builder
        Customer customer = new Customer.CustomerBuilder()
                .setCustomer_id(1)
                .setUser_name("JamesSmith")
                .setPassword("password123")
                .setFirst_name("James")
                .setLast_name("Smith")
                .setPhone("4748995503")
                .setEmail("james.smith@gmail.com")
                .setRegistration_date("2010-02-01")
                .build();

        System.out.println("The customer has a customer_id: " + customer.getCustomer_id()
                + ", user_name: '" + customer.getUser_name() + '\''
                + ", password: '" + customer.getPassword() + '\''
                + ", first_name: '" + customer.getFirst_name() + '\''
                + ", last_name: '" + customer.getLast_name() + '\''
                + ", phone: '" + customer.getPhone() + '\''
                + ", email: '" + customer.getEmail() + '\''
                + ", registration_date: '" + customer.getRegistration_date() + '\'');
    }
}
