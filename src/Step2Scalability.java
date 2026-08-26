import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Step 2: Scalability Comparison.
 * 
 * Traditional "Platform" threads are wrappers around OS threads. They are 
 * expensive (1MB+ stack size). Spawning 100,000 of them would likely crash 
 * your JVM or slow down your system.
 * 
 * Virtual threads are managed by the JVM and are extremely lightweight.
 */
public class Step2Scalability {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 100_000;
        AtomicInteger counter = new AtomicInteger();

        System.out.println("Spawning " + threadCount + " virtual threads...");
        long start = System.currentTimeMillis();

        var threads = IntStream.range(0, threadCount)
                .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
                    counter.incrementAndGet();
                    // Each thread does a tiny bit of work
                }))
                .toList();

        threads.forEach(Thread::start);

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();
        System.out.println("Successfully finished " + counter.get() + " tasks.");
        System.out.println("Time taken: " + (end - start) + "ms");
        
        // Note: If you tried this with Thread.ofPlatform(), your machine 
        // might run out of memory or reach the OS thread limit.
    }
}
