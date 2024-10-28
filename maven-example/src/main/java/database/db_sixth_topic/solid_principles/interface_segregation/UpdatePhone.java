package database.db_sixth_topic.solid_principles.interface_segregation;


/**
 * Interface Segregation principle:
 * A client should never be forced to implement an interface that it doesn't use,
 * or clients shouldn't be forced to depend on methods they do not use.
 * Only the classes need the updatePhone method will implement this interface.
 */
public interface UpdatePhone {
    void updatePhone(String phone, Integer id);
}
