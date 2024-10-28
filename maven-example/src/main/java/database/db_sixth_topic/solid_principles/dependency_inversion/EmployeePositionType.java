package database.db_sixth_topic.solid_principles.dependency_inversion;

/**
 * Dependency Inversion principle:
 * Entities must depend on abstractions, not on concretions.
 * It states that the high-level module must not depend on the low-level module,
 * but they should depend on abstractions.
 * Filter is the high-level module, AccountInterestType and EmployeePositionType are the low-level modules.
 */

public enum EmployeePositionType implements IFilterValue {
    MANAGING_DIRECTOR("Managing Director"),
    SENIOR_VICE_PRESIDENT("Senior Vice President"),
    VICE_PRESIDENT("Vice President"),
    ASSOCIATE("Associate"),
    ANALYST("Analyst");

    private final String value;

    EmployeePositionType(String value) { this.value = value; }

    @Override
    public String getValue() { return value; }
}
