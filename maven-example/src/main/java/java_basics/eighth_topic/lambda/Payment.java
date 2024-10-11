package java_basics.eighth_topic.lambda;

public class Payment {
    private String name;
    private String method;
    private double price;
    private String dueDate;
    public Payment(String name, String method, double price, String dueDate) {
        this.name = name;
        this.method = method;
        this.price = price;
        this.dueDate = dueDate;
    }

    public String getName() {
        return name;
    }

    public String getMethod() {
        return method;
    }

    public double getPrice() {
        return price;
    }

    public String getDueDate() {
        return dueDate;
    }
}
