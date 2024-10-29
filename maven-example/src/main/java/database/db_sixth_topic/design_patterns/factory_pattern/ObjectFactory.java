package database.db_sixth_topic.design_patterns.factory_pattern;

/**
 * Factory Design Pattern:
 * In factory design pattern we create an object from a factory class without exposing the creation logic
 * to the client. Objects will be created by an interface or abstract class. The type of the object
 * will be one of the subclasses, and it will depend upon the input which we pass to the factory.
 */

public class ObjectFactory {

    public Object getObject(String objectType) {
        if (objectType == null) {
            return null;
        }
        if (objectType.equalsIgnoreCase("Customer")) {
            return new CreateCustomer();
        } else if (objectType.equalsIgnoreCase("Branch")) {
            return new CreateBranch();
        }
        return null;
    }
}
