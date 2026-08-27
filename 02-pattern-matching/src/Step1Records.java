/**
 * Step 1: Records
 * 
 * Records are a concise way to create classes that are transparent holders for shallowly immutable data.
 * The compiler automatically generates:
 * - Private, final fields
 * - A canonical constructor
 * - Accessor methods (e.g., name(), age())
 * - equals(), hashCode(), and toString()
 */
public class Step1Records {
    
    // A record definition is a one-liner!
    public record Person(String name, int age) {}

    public static void main(String[] args) {
        // 1. Creation
        Person alice = new Person("Alice", 30);
        Person bob = new Person("Bob", 25);

        // 2. Accessing data (notice: no "get" prefix)
        System.out.println("Name: " + alice.name());
        System.out.println("Age: " + alice.age());

        // 3. Built-in toString()
        System.out.println("ToString: " + alice);

        // 4. Built-in equals()
        Person alice2 = new Person("Alice", 30);
        System.out.println("Is alice equal to alice2? " + alice.equals(alice2));

        // CHALLENGE: Try to change alice's name. (Hint: Records are immutable!)
        // alice.name = "Malice"; // This would fail to compile
    }
}
