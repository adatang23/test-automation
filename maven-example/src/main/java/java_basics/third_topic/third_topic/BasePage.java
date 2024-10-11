package java_basics.third_topic.third_topic;

public abstract class BasePage implements Searchable, Securable, Selectable, Timeoutable, Checkoutable {
    // Common functionality for all pages
    public abstract void openPage();
}
