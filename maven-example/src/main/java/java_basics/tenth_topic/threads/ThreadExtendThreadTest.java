package java_basics.tenth_topic.threads;

public class ThreadExtendThreadTest extends Thread {
    private String selection;
    private String message;

    ThreadExtendThreadTest(String selection, String message) {
        this.selection = selection;
        this.message = message;
    }

    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " is starting");
        for (int i=0; i < 3; i++) {
            try {
                if (selection.toLowerCase().startsWith("ThrowException".toLowerCase())) {
                    throw new InterruptedException("Thread interrupted");
                }
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is running");
                System.out.println("Selection: " + selection + ", Message: " + message);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted by " + selection);
            }
        System.out.println(Thread.currentThread().getName() + " is finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Test t1.interrupt() when throw exception
        System.out.println("Test interrupt() when throw exception:");
        ThreadExtendThreadTest t1 = new ThreadExtendThreadTest("ThrowException", "Hello World!");
        ThreadExtendThreadTest t2 = new ThreadExtendThreadTest("Default", "A computer course");
        t1.start();
        t2.start();
        try {
            t1.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        t1.join();
        t2.join();
        System.out.println("");


        // Test t3.interrupt() when no throw exception
        System.out.println("Test interrupt() when not throw exception:");
        ThreadExtendThreadTest t3 = new ThreadExtendThreadTest("Default", "Hello World!");
        ThreadExtendThreadTest t4 = new ThreadExtendThreadTest("Default", "A Computer course");
        t3.start();
        t4.start();
        try {
            t3.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        t3.join();
        t4.join();
        System.out.println("");
    }
}
