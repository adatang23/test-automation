package database.db_sixth_topic.solid_principles.open_closed;

/**
 * Open Closed principle:
 * Objects or entities should be open for extension but closed for modification.
 * The ObjectCreateBase class should be extendable without modifying the class itself.
 */

public abstract class ObjectCreateBase {

    public abstract void create(Object object);
}
