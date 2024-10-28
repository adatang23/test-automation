package database.db_sixth_topic.design_patterns.abstract_factory_pattern;

public abstract class AbstractFactory {
    public abstract CreatePerson getPerson(String personType);
    public abstract CreateFacility getFacility(String facilityType);
}
