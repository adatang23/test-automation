package database.db_sixth_topic.design_patterns.strategy_pattern;

public class StringComparisionByOperator implements Strategy {
    @Override
    public boolean strinComparision(String s1, String s2) {
        return s1 == s2;
    }
}
