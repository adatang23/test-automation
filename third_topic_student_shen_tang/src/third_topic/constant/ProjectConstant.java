package third_topic.constant;

public final class ProjectConstant {

    public static final String APP_NAME = "Payment Systems";
    public static final String USER_NUMBER = "1a234567890";
    public static int paymentsCount;

    private ProjectConstant() {
        // Private constructor to prevent instantiation
    }

    // Final method
    public static final void displayAppName() {
        System.out.println("App Name: " + APP_NAME);
    }

    public static final void displayUserNumber() {
        System.out.println("User Number: " + USER_NUMBER);
    }

    public static void displayConfig() {
        //ProjectConstant projectConstant = new ProjectConstant();
        ProjectConstant.displayAppName();
        ProjectConstant.displayUserNumber();
    }

    public static void incrementPaymentsCount() {
        paymentsCount++;
        System.out.println("Payments count incremented: " + paymentsCount);
    }
}
