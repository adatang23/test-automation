package database.db_sixth_topic.design_patterns.listener_pattern;

/**
 * Listener Pattern:
 * Java listener design pattern comes under behavioural design patterns. According to GoF, listener design pattern
 * states that define a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically.
 */

public abstract class Listener {
    protected Subject subject;
    public abstract void update(Integer id);
}
