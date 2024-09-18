package ninth_topic.reflection;
import ninth_topic.enums.UserType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class Main {

    // Please find the reflection implementation at ninth_topic/enums/TransactionList.java
    @BeforeMethod(alwaysRun = true)
    public void setupConfiguration(Method method) {
        try {
            String envString = "QA"; // Assume "QA" is our environment
            System.out.println("Environment is: " + envString);
            // Dynamically configure based on the method name
            String methodName = method.getName();
            String testType = "Default";
            if (methodName.contains("Chrome")) {
                testType = "Chrome";
            } else if (methodName.contains("FireFox")) {
                testType = "FireFox";
            } else if (methodName.contains("Safari")) {
                testType = "Safari";
            }
            System.out.println("Setting up test: " + methodName + "\n"
                    + "It is a " + testType + " test.");
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
}
