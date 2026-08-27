/**
 * Step 5: Manual Testing with Assertions.
 * 
 * This step demonstrates how to write simple tests using the Java 'assert' keyword.
 * Assertions are a great way to verify assumptions in your code without 
 * needing a full testing framework like JUnit.
 * 
 * KEY CONCEPT: By default, assertions are DISABLED at runtime.
 * To run this test, you MUST use the -ea (enableassertions) flag.
 */
public class Step5Testing {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Manual Test: Virtual Thread Properties...");

        // 1. Create a virtual thread
        Thread vThread = Thread.ofVirtual()
                .name("test-thread")
                .unstarted(() -> {
                    // We can also use assertions inside the thread
                    assert Thread.currentThread().isVirtual() : "Inner check: Should be virtual";
                });

        // 2. Perform Assertions (The Test)
        // Syntax: assert <condition> : <failure message>;
        
        System.out.println("Checking if the thread is virtual before starting...");
        assert vThread.isVirtual() : "Test Failed: vThread should be a virtual thread!";
        
        System.out.println("Checking thread state...");
        assert vThread.getState() == Thread.State.NEW : "Test Failed: Thread should be in NEW state";

        vThread.start();
        vThread.join();

        System.out.println("Checking thread state after completion...");
        assert vThread.getState() == Thread.State.TERMINATED : "Test Failed: Thread should be TERMINATED";

        System.out.println("\n[SUCCESS] All assertions passed!");
        System.out.println("Note: If you didn't see an AssertionError, the test passed.");
        System.out.println("Note: Ensure you ran with 'java -ea -cp bin Step5Testing'");
    }
}
