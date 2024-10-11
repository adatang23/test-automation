package java_basics.third_topic.third_topic;

public interface Searchable {
    default void search(String query) {
        System.out.println("Searching for " + query);
    }
}