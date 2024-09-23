package tenth_topic.threads;

public class ThreadRunnableTest implements Runnable {
    private String message;
    ThreadRunnableTest(String message) {
        this.message = message;
    }

    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " is starting");
        for (int i=0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is running");
                System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " is finished");
    }

    public static void main(String args[]) throws InterruptedException {
        // Compare the differences between using join() and not using join()
        System.out.println("Test using join():");
        Thread t1 = new Thread(new ThreadRunnableTest("Hello World!"));
        Thread t2 = new Thread(new ThreadRunnableTest("A Computer Course"));
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println("");

        System.out.println("Test without using join():");
        Thread t3 = new Thread(new ThreadRunnableTest("Hello World!"));
        Thread t4 = new Thread(new ThreadRunnableTest("A Computer Course"));
        t3.start();
        t4.start();
        System.out.println("");
    }
}
