package database.db_sixth_topic.design_patterns.abstract_factory_pattern;

public class FactoryGenerator {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Person")) {
            return new PersonFactory();
        } else if (choice.equalsIgnoreCase("Facility")) {
            return new FacilityFactory();
        }
        return null;
    }
}
