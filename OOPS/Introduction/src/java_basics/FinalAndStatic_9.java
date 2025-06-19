package java_basics;

// Final class - cannot be inherited
final class Constant {

    // Static final variable - constant (recommended naming in UPPER_CASE)
    public static final double PI = 3.14159;

    // Static variable - shared across all objects
    static int objectCount = 0;

    // Final instance variable - must be initialized once
    final int id;

    // Constructor
    public Constant(int id) {
        this.id = id;              // final variable initialized once here
        objectCount++;            // static variable increments with each object
    }

    // Final method - cannot be overridden in subclasses
    public final void showId() {
        System.out.println("ID: " + id);
    }

    // Static method - can be called without object
    public static void showCount() {
        System.out.println("Number of objects created: " + objectCount);
    }
}

// Uncommenting the below class will throw error because Constant is final
// class SubClass extends Constant {}

public class FinalAndStatic_9 {
    public static void main(String[] args) {
        System.out.println("PI constant (static final): " + Constant.PI);

        // Creating objects
        Constant obj1 = new Constant(101);
        Constant obj2 = new Constant(102);

        // Calling final method
        obj1.showId();
        obj2.showId();

        // Accessing static variable via static method
        Constant.showCount();
    }
}
