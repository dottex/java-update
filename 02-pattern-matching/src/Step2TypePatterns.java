/**
 * Step 2: Type Patterns
 * 
 * Type patterns allow you to combine a type check (instanceof) with a variable declaration.
 * If the check passes, the variable is automatically cast and ready to use.
 */
public class Step2TypePatterns {
    
    public static void main(String[] args) {
        Object input = "Hello, Java 21!";

        // OLD WAY:
        if (input instanceof String) {
            String s = (String) input; // Explicit cast required
            System.out.println("Old Way: " + s.toUpperCase());
        }

        // MODERN WAY (Pattern Matching for instanceof):
        // 's' is the pattern variable. It's only in scope if the check is true.
        if (input instanceof String s) {
            System.out.println("Modern Way: " + s.toUpperCase());
        }

        // It works with other types too
        Object number = 42;
        if (number instanceof Integer i && i > 40) {
            System.out.println("The number is large enough: " + i);
        }

        // CHALLENGE: What happens if you try to use 's' outside the if block?
        // System.out.println(s); // Try uncommenting this!
    }
}
