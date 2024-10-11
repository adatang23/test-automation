package java_basics.third_topic.third_topic;

public interface Checkoutable {
    default void checkOut(String accountName) {
        System.out.println("Checking out of " + accountName);
    }
}
