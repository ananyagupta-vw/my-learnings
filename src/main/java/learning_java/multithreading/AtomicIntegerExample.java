package learning_java.multithreading;

// CAS - Compare and Swap is an atomic instruction used in multithreading to achieve synchronization.
// It compares the current value of a variable to an expected value and, if they are the same, updates the variable to a new value.
// This operation is performed atomically, meaning it is indivisible and prevents race conditions without using locks.

// AtomicInteger is a class in the java.util.concurrent.atomic package that provides an integer value that can be updated atomically.

public class AtomicIntegerExample {
    // write a program to demonstrate CAS using AtomicInteger
    public static void main(String[] args) throws InterruptedException {
        java.util.concurrent.atomic.AtomicInteger atomicInteger = new java.util.concurrent.atomic.AtomicInteger(0);

        // Create two threads that increment the atomic integer
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                atomicInteger.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        // Print the final value of the atomic integer
        System.out.println("Final value: " + atomicInteger.get());
    }
}
