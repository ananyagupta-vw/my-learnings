package learning_java.multithreading;


// synchronized keyword will ensure that only one thread can access the increment method at a time, preventing race conditions and ensuring thread safety.

public class SynchronizedExample {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static synchronized int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {

        // Create two threads that increment the count
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print the final count
        System.out.println("Final count: " + getCount());
    }
}
