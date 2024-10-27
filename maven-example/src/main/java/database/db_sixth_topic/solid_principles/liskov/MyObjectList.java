package database.db_sixth_topic.solid_principles.liskov;

/**
 * Liskov principle:
 * Every subclass or derived class should be substitutable for their base or parent class.
 * BranchListImpl or CustomerListImpl class can be substitutable for MyObjectList interface.
 */
public interface MyObjectList<T> {
    void add(T element);
    T get(int index);
    void remove(int index);
    int size();
}
