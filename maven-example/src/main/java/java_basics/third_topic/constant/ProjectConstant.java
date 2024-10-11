package java_basics.third_topic.constant;

public final class ProjectConstant {

    public static final String APP_NAME = "Payment Systems";
    public static final String USER_NUMBER = "1a234567890";

    public static int paymentsCount;
    private ProjectConstant() {
        // Private constructor to prevent instantiation
    }

    // Final method
    public final void displayAppName() {
        System.out.println("App Name: " + APP_NAME);
    }
    public final void displayUserNumber() { System.out.println("User Number: " + USER_NUMBER);}

    public static void displayConfig() {
        ProjectConstant projectConstant = new ProjectConstant();
        projectConstant.displayAppName();
        projectConstant.displayUserNumber();
    }

    public static void incrementPaymentsCount() {
        paymentsCount++;
        System.out.println("Payments count incremented: " + paymentsCount);
    }

}
