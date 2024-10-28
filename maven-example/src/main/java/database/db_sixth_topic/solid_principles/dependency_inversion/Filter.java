package database.db_sixth_topic.solid_principles.dependency_inversion;

/**
 * Dependency Inversion principle:
 * Entities must depend on abstractions, not on concretions.
 * It states that the high-level module must not depend on the low-level module,
 * but they should depend on abstractions.
 * Filter is the high-level module, AccountInterestType and EmployeePositionType are the low-level modules.
 */

public class Filter {
    private final String name;
    private final String value;

    public Filter(final IFilterValue filterValue) {
        this.name = filterValue.toString();
        this.value = filterValue.getValue();
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Filter{name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Filter filter1 = new Filter(EmployeePositionType.MANAGING_DIRECTOR);
        Filter filter2 = new Filter(EmployeePositionType.ASSOCIATE);
        Filter filter3 = new Filter(AccountInterestType.CHECKING);
        Filter filter4 = new Filter(AccountInterestType.CREDIT_CARD);
        System.out.println(filter1);
        System.out.println(filter2);
        System.out.println(filter3);
        System.out.println(filter4);
    }
}
