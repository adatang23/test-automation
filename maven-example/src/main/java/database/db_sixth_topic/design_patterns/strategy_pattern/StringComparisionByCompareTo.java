package database.db_sixth_topic.design_patterns.strategy_pattern;

public class StringComparisionByCompareTo implements Strategy {
    @Override
    public boolean strinComparision(String s1, String s2) {
        if(s1.compareTo(s2) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
