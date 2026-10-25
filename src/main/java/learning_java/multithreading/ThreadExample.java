package learning_java.multithreading;

public class ThreadExample {
    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
        });

        th1.start();
        System.out.println("Main thread is running");

    }
}
