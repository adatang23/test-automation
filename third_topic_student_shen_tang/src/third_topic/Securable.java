package third_topic;

public interface Securable {
    default void secure(String verifyCode) {
        System.out.println("Secured by " + verifyCode);
    }
}
