package third_topic;

public class AppConfig {
    public static final String CONFIG_NAME = "AppConfig";

    static {
        // Static block for initialization
        System.out.println("Static block executed. Config Name: " + CONFIG_NAME);
    }

    public static void loadConfiguration() {
        System.out.println("Loading configuration...");
    }
}
