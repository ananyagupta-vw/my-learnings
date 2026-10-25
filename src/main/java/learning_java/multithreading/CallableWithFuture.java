package learning_java.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithFuture {
    public static void main(String[] args) throws Exception {
       ExecutorService pool = Executors.newFixedThreadPool(10);

       Callable<Integer> task = () -> 1 + 1;

       Future<Integer> future = pool.submit(task);

         System.out.println("Doing other work...");

        Integer result = future.get();
        System.out.println("Result: " + result);
        pool.shutdown();
    }
}
