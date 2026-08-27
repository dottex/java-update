/**
 * Step 1: The Basics of Virtual Threads.
 * 
 * In this step, we learn how to create a single virtual thread.
 * Java 21 introduced the Thread.Builder API to make it easy to choose 
 * between platform threads and virtual threads.
 */
public class Step1Basic {
    public static void main(String[] args) throws InterruptedException {
        // 1. Create a virtual thread using the builder
        Thread vThread = Thread.ofVirtual()
                .name("my-virtual-thread")
                .unstarted(() -> {
                    System.out.println("Hello from a Virtual Thread!");
                    System.out.println("Thread Info: " + Thread.currentThread());
                });

        System.out.println("Starting virtual thread...");
        vThread.start();

        // 2. Wait for the virtual thread to finish
        // Because virtual threads are daemon threads by default, the JVM 
        // will exit if the main thread finishes before they do.
        vThread.join();
        
        System.out.println("Main thread finished.");
    }
}
