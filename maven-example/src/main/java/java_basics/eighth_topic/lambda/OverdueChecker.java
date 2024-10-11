package java_basics.eighth_topic.lambda;

public interface OverdueChecker<T> {
    boolean isOverdue(T payment);
}
