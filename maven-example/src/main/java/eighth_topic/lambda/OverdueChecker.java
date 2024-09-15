package eighth_topic.lambda;

public interface OverdueChecker<T> {
    boolean isOverdue(T payment);
}
