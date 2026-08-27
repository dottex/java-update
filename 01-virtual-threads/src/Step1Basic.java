/**
 * Step 1: The Basics of Virtual Threads.
 * 
 * In this step, we learn how to create a single virtual thread.
 * Java 21 introduced the Thread.Builder API to make it easy to choose 
 * between platform threads and virtual threads.
 */
public class Step1Basic {
    public static void main(String[] args) throws InterruptedException {
        // Approach 1: Using the Builder
        // Useful when you need to configure properties like the thread name.
        Thread vThread1 = Thread.ofVirtual()
                .name("my-virtual-thread")
                .unstarted(() -> {
                    System.out.println("Hello from Virtual Thread 1 (Builder)!");
                    System.out.println("Thread Info: " + Thread.currentThread());
                });

        System.out.println("Starting virtual thread 1...");
        vThread1.start();

        // Approach 2: Using the startVirtualThread factory
        // The quickest way to start a virtual thread if no configuration is needed.
        Thread vThread2 = Thread.startVirtualThread(() -> {
            System.out.println("Hello from Virtual Thread 2 (Factory)!");
        });

        // 2. The "Join" operation
        // The Main Thread (Caller) stops here and WAITS for the target threads to finish.
        // Mnemonic: "Wait for them to JOIN the party."
        // Other languages call this: await (JS/C#), wait (C), or get (Java Futures).
        
        vThread1.join(); // Main thread waits for vThread1 to join the main execution path
        vThread2.join(); // Main thread waits for vThread2 to join the main execution path
        
        System.out.println("Main thread finished.");
    }
}
