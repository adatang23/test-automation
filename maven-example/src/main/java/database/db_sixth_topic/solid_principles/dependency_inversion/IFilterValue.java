package database.db_sixth_topic.solid_principles.dependency_inversion;

/**
 * Dependency Inversion principle:
 * Entities must depend on abstractions, not on concretions.
 * It states that the high-level module must not depend on the low-level module,
 * but they should depend on abstractions.
 * Filter is the high-level module, AccountInterestType and EmployeePositionType are the low-level modules.
 */
public interface IFilterValue {
    String getValue();
}
