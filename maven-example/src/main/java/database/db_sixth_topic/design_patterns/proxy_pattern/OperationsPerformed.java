package database.db_sixth_topic.design_patterns.proxy_pattern;

/**
 * Proxy Pattern:
 * Java proxy design pattern comes under the structural design pattern category.
 * In proxy design pattern we use a surrogate or placeholder to control the access of original object.
 */

public interface OperationsPerformed {
    public void view(Integer id);
    public void edit(String phone, Integer id);
}
