package database.db_sixth_topic.design_patterns.abstract_factory_pattern;

public class PersonFactory extends AbstractFactory {
    @Override
    public CreatePerson getPerson(String personType) {
        if(personType == null) {
            return null;
        }
        if (personType.equalsIgnoreCase("Customer")) {
            return new CreateCustomerAbstract();
        }
        return null;
    }

    @Override
    public CreateFacility getFacility(String facilityType) {
        return null;
    }
}
