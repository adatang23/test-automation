package database.db_sixth_topic.design_patterns.factory_pattern;

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
