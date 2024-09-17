package ninth_topic.reflection;
import ninth_topic.enums.UserType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class Main {

    // Please find the reflection implementation at ninth_topic/enums/TransactionList.java

    private static Map<String, String> CONFIG = new HashMap<>();

    @BeforeMethod(alwaysRun = true)
    public void setupConfiguration(Method method) {
        try {
            String envString = "QA"; // Assume "QA" is our environment
            CONFIG.put("env", envString);
            System.out.println("Environment is: " + envString);

            // Dynamically configure based on the method name
            String methodName = method.getName();
            if (methodName.contains("Chrome")) {
                CONFIG.put("browser", "Chrome");
            } else if (methodName.contains("Firefox")) {
                CONFIG.put("browser", "Firefox");
            } else {
                CONFIG.put("browser", "DefaultBrowser");
            }

            // Log the selected configuration
            System.out.println("Setting up test: " + methodName);
            System.out.println("Configured browser: " + CONFIG.get("browser"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByUserType() {
        // Test collection streaming findByUserType() in ninth_topic/enums/UserType
        System.out.println("Test collection streaming findByUserType():");
        String customInfor = "Guest_cmiller06_090624";
        String[] cust = customInfor.split("_");
        UserType customType = UserType.findByUserType(cust[0]);
        System.out.println(customType + "\n");
    }

    public static void main(String[] args) {

    }
}
