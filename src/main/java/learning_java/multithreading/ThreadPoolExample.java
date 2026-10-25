package learning_java.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Thread Pool is a collection of reusable threads that can be used to execute tasks concurrently.
// It helps in managing the number of threads and improves performance by reusing existing threads instead of creating new ones for each task.

public class ThreadPoolExample {

    public static void main(String[] args) {
        // ExecutorService is an interface that represents a thread pool and provides methods to manage and control the execution of tasks.
        // Fixed Thread Pool factory uses unbounded task queue meaning if tasks arrive faster than they are executed then the queue will grow indefinitely.
        ExecutorService pool = Executors.newFixedThreadPool(3);


        pool.submit(()->{
            System.out.println("Task 1 is running in thread: " + Thread.currentThread().getName());
        }); // send a task to the thread pool

        pool.shutdown(); // stop accepting new tasks and finish existing tasks
    }
}

// ForkJoinPool is a special type of thread pool designed for parallel processing of tasks that can be broken down into smaller subtasks.
// It uses a work-stealing algorithm to efficiently distribute tasks among available threads,
// allowing for better utilization of CPU resources and improved performance in certain scenarios.

// FixedThreadPool is a type of thread pool that maintains a fixed number of threads to execute tasks concurrently.
// unbounded task queue meaning if tasks arrive faster than they are executed then the queue will grow indefinitely.

// CachedThreadPool is a type of thread pool that creates new threads as needed and reuses previously constructed threads when they are available.

