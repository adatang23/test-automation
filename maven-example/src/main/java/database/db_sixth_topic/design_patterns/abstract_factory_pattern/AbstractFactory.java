package database.db_sixth_topic.design_patterns.abstract_factory_pattern;

/**
 * Abstract Factory:
 * In abstract factory design pattern a super factory is responsible to create other factories of related objects.
 * A factory will be created from a super factory class without exposing the creation logic to the client.
 * Now, this factory will be responsible to create the objects based on Factory Design Pattern.
 */

public abstract class AbstractFactory {
    public abstract CreatePerson getPerson(String personType);
    public abstract CreateFacility getFacility(String facilityType);
}
