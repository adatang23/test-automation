package database.db_sixth_topic.solid_principles.dependency_inversion;


/**
 * Dependency Inversion principle:
 * Entities must depend on abstractions, not on concretions.
 * It states that the high-level module must not depend on the low-level module,
 * but they should depend on abstractions.
 * Filter is the high-level module, AccountInterestType and EmployeePositionType are the low-level modules.
 */

public enum AccountInterestType implements IFilterValue {
    CHECKING(0.01),
    SAVING(0.02),
    CERTIFICATE_OF_DEPOSIT(0.04),
    MONEY_MARKET(0.05),
    CREDIT_CARD(0.20);

    private final double value;

    AccountInterestType(double value) { this.value = value; }

    @Override
    public String getValue() { return Double.toString(value); }
}
