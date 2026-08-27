/**
 * Step 4: Switch Expressions & Patterns
 * 
 * Java's 'switch' has evolved from a statement to a powerful expression that supports pattern matching.
 */
public class Step4SwitchPatterns {
    
    public record Point(int x, int y) {}

    public static void main(String[] args) {
        Object[] objects = { "Hello", 42, new Point(1, 2), null };

        for (Object obj : objects) {
            // 1. Switch Expression (returns a value)
            // 2. Pattern Matching in case labels
            String description = switch (obj) {
                case String s -> "A string of length " + s.length();
                case Integer i -> "An integer: " + i;
                case Point(int x, int y) -> "A point at (" + x + "," + y + ")";
                case null -> "It's null!";
                default -> "Unknown type";
            };

            System.out.println("Object: " + obj + " -> " + description);
        }

        // 3. Guarded Patterns (using 'when')
        Object input = new Point(0, 5);
        String position = switch (input) {
            case Point(int x, int y) when x == 0 && y == 0 -> "At the origin";
            case Point(int x, int y) when x == 0 -> "On the Y-axis";
            case Point(int x, int y) when y == 0 -> "On the X-axis";
            case Point p -> "Somewhere else: " + p;
            default -> "Not a point";
        };
        System.out.println("Position: " + position);

        // CHALLENGE: Try to remove the 'default' case. Does it still compile? 
        // (Hint: Switch expressions must be exhaustive!)
    }
}
