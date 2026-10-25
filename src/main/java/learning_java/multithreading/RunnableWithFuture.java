package learning_java.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableWithFuture {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();

        Runnable task = () -> {
            try {
                Thread.sleep(2000); // Simulate a long-running task
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        pool.execute(task);

    }
}
