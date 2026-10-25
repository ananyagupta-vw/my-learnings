package learning_java.multithreading;

import java.util.concurrent.CompletableFuture;

// CompletableFuture is a class in the java.util.concurrent package that represents a future result of an asynchronous computation.
public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> customer =
                CompletableFuture.supplyAsync(() -> "Ananya").thenApply(String::toUpperCase).exceptionally(err -> "Ananya");

        CompletableFuture<Integer> orders =
                CompletableFuture.supplyAsync(() -> 5);

        CompletableFuture<String> summary =
                customer.thenCombine(
                        orders,
                        (name, count) -> name + " has " + count + " orders"
                );

        System.out.println(summary.join());
    }
}
