package database.db_sixth_topic.design_patterns.strategy_pattern;

public class Context {
    private Strategy strategy;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String s1, String s2) {
        return strategy.strinComparision(s1, s2);
    }
}
