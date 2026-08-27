import java.util.concurrent.Executors;
import java.time.Duration;

/**
 * Step 4: Blocking Behavior.
 * 
 * Virtual threads shine when code blocks (sleeps, waits for I/O, etc.).
 * When a virtual thread blocks, the JVM "unmounts" it from the carrier OS thread,
 * allowing other virtual threads to run on that same OS thread.
 */
public class Step4Blocking {
    public static void main(String[] args) {
        System.out.println("Starting 1,000 tasks that each block for 1 second...");
        long start = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000; i++) {
                executor.submit(() -> {
                    try {
                        // This blocks the virtual thread, but NOT the OS thread!
                        Thread.sleep(Duration.ofSeconds(1));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Finished 1,000 blocking tasks.");
        System.out.println("Total time: " + (end - start) + "ms");
        System.out.println("Notice that the total time is very close to 1 second!");
        System.out.println("If we used a fixed pool of 10 platform threads, " +
                           "this would take 100 seconds.");
    }
}
