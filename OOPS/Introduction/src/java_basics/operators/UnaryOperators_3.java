package java_basics.operators;

public class UnaryOperators_3 {
    public static void main(String[] args) {
        // Integer variable
        int a = 5;

        // Double variable
        double b = 5.5;

        // Boolean variable
        boolean isActive = true;

        System.out.println("---- Integer Unary Operations ----");
        System.out.println("Original value of a: " + a);
        System.out.println("Unary minus (-a): " + (-a));             // Negation: -5
        System.out.println("Unary plus (+a): " + (+a));              // No change: 5
        System.out.println("Pre-increment (++a): " + (++a));         // Increments to 6, then prints 6
        System.out.println("Post-increment (a++): " + (a++));        // Prints 6, then increments to 7
        System.out.println("After post-increment, a: " + a);         // Now a = 7
        System.out.println("Pre-decrement (--a): " + (--a));         // Decrements to 6, then prints 6
        System.out.println("Post-decrement (a--): " + (a--));        // Prints 6, then decrements to 5
        System.out.println("After post-decrement, a: " + a);         // Now a = 5

        System.out.println("\n---- Double Unary Operations ----");
        System.out.println("Original value of b: " + b);
        System.out.println("Unary minus (-b): " + (-b));             // Negation: -5.5
        System.out.println("Unary plus (+b): " + (+b));              // No change: 5.5
        System.out.println("Pre-increment (++b): " + (++b));         // Increments to 6.5, then prints 6.5
        System.out.println("Post-increment (b++): " + (b++));        // Prints 6.5, then increments to 7.5
        System.out.println("After post-increment, b: " + b);         // Now b = 7.5
        System.out.println("Pre-decrement (--b): " + (--b));         // Decrements to 6.5, then prints 6.5
        System.out.println("Post-decrement (b--): " + (b--));        // Prints 6.5, then decrements to 5.5
        System.out.println("After post-decrement, b: " + b);         // Now b = 5.5

        System.out.println("\n---- Boolean Unary Operation (! operator) ----");
        System.out.println("Original value of isActive: " + isActive);        // true
        System.out.println("Negation (!isActive): " + (!isActive));           // false

        System.out.println("\n---- Key Notes ----");
        System.out.println("- Unary minus (-) changes sign.");
        System.out.println("- Unary plus (+) keeps value as-is.");
        System.out.println("- ++ and -- work for numeric types: pre applies before use, post after use.");
        System.out.println("- ! (logical NOT) inverts a boolean value: true → false, false → true.");
    }
}
