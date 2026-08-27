/**
 * Step 5: Sealed Classes & Exhaustiveness
 * 
 * Sealed classes and interfaces restrict which other classes may extend or implement them.
 * This allows the compiler to know ALL possible subtypes, enabling exhaustive switch expressions
 * WITHOUT a 'default' clause.
 */
public class Step5SealedClasses {
    
    // 1. Define a sealed hierarchy
    public sealed interface Shape permits Circle, Rectangle, Square {}

    public record Circle(double radius) implements Shape {}
    public record Rectangle(double w, double h) implements Shape {}
    public record Square(double side) implements Shape {}

    public static void main(String[] args) {
        Shape shape = new Circle(5.0);

        // 2. Exhaustive Switch
        // Because Shape is sealed, the compiler knows there are ONLY 3 possible types.
        // If you remove one of these cases, the code will fail to compile!
        double area = switch (shape) {
            case Circle(double r) -> Math.PI * r * r;
            case Rectangle(double w, double h) -> w * h;
            case Square(double s) -> s * s;
            // No default needed!
        };

        System.out.println("Area of " + shape.getClass().getSimpleName() + " is " + area);

        // CHALLENGE: Try to add a new class 'Triangle' that implements Shape. 
        // What happens? (Hint: You must add it to the 'permits' list first).
        // Then, see how the switch expression above starts complaining!
    }
}
