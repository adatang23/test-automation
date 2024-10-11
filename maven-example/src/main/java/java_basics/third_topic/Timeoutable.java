package java_basics.third_topic;

public interface Timeoutable {
    default void timeout(boolean stayOrNot) {
        System.out.println("Almost timing out, stay on this page? " + stayOrNot);
    }
}
