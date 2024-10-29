package database.db_sixth_topic.design_patterns.mvc_pattern;

/**
 * MVC Pattern:
 * The MVC design pattern is a software architecture pattern that separates an application into
 * three main components: Model, View, and Controller, making it easier to manage and maintain the codebase.
 * It also allows for the reusability of components and promotes a more modular approach to software development.
 * Model: Customer, View: CustomerView, Controller: CustomerController
 */

public class CustomerView {
    public void printCustomerDetails(String userName, String phone, String email) {
        System.out.println("Customer{Name='" + userName + '\'' + ", Phone='" + phone + '\''
                + ", Email='" + email + '\'' + '}');
    }
}
