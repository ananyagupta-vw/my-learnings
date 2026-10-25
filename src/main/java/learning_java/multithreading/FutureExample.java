package learning_java.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// A future is a placeholder object for a result that is initially unknown, usually because the computation of its value is still in progress.
// It allows you to retrieve the result of an asynchronous computation once it is complete.

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);


        Future<Integer> future = pool.submit(() -> {
            Thread.sleep(2000); // Simulate a long-running task
            return 42;
        });

        System.out.println("Doing other work...");

        System.out.println("Is the future done? " + future.isDone()); // Check if the computation is complete

        // Retrieve the result of the asynchronous computation
        Integer result = future.get();
        System.out.println("Result: " + result);

        pool.shutdown();
    }
}
