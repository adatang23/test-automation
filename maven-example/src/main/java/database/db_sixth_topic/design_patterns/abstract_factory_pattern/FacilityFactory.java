package database.db_sixth_topic.design_patterns.abstract_factory_pattern;

public class FacilityFactory extends AbstractFactory {
    @Override
    public CreatePerson getPerson(String personType) {
        return null;
    }

    @Override
    public CreateFacility getFacility(String facilityType) {
        if (facilityType == null) {
            return null;
        }
        if (facilityType.equalsIgnoreCase("AccountType")) {
            return new CreateAccountTypeAbstract();
        } else if (facilityType.equalsIgnoreCase("Branch")) {
            return new CreateBranchAbstract();
        }
        return null;
    }
}
