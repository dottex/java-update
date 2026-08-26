import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Step 3: The Virtual Thread Executor.
 * 
 * In production, we rarely manage threads manually. We use ExecutorService.
 * Java 21 added a new executor that creates a new virtual thread for every task.
 */
public class Step3Executor {
    public static void main(String[] args) {
        // This is the "Gold Standard" for using virtual threads.
        // It's AutoCloseable, so we can use try-with-resources.
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            
            for (int i = 0; i < 10; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Processing task " + taskId + 
                                       " on thread: " + Thread.currentThread());
                });
            }
            
        } // executor.close() is called here, which waits for all tasks to finish.

        System.out.println("All tasks completed.");
    }
}
