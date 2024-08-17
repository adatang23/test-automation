package third_topic;

public interface Searchable {
    default void search(String query) {
        System.out.println("Searching for " + query);
    }
}