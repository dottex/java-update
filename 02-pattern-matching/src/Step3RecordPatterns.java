/**
 * Step 3: Record Patterns
 * 
 * Record patterns take type patterns a step further by deconstructing the record
 * directly into its components.
 */
public class Step3RecordPatterns {
    
    public record Point(int x, int y) {}
    public record ColoredPoint(Point p, String color) {}

    public static void main(String[] args) {
        Object obj = new ColoredPoint(new Point(10, 20), "Red");

        // 1. Basic Deconstruction
        if (obj instanceof ColoredPoint(Point p, String color)) {
            System.out.println("Color: " + color + " at " + p);
        }

        // 2. Nested Deconstruction (Very powerful!)
        if (obj instanceof ColoredPoint(Point(int x, int y), String color)) {
            System.out.println("Nested Access -> X: " + x + ", Y: " + y + ", Color: " + color);
        }

        // 3. Var keyword in patterns
        if (obj instanceof ColoredPoint(var p, var color)) {
            System.out.println("Using var -> " + color);
        }

        // CHALLENGE: Create a record 'Circle(Point center, int radius)' and write a 
        // method that uses a record pattern to print the area only if the circle is at the origin (0,0).
    }
}
