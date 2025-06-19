package java_basics.operators;

public class RelationalOperators_4 {
    public static void main(String[] args) {
        // Integer variables
        int a = 10;
        int b = 20;

        // Double variables
        double x = 15.5;
        double y = 10.0;

        System.out.println("---- Relational Operators with Integers ----");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a == b : " + (a == b));     // false
        System.out.println("a != b : " + (a != b));     // true
        System.out.println("a < b  : " + (a < b));      // true
        System.out.println("a > b  : " + (a > b));      // false
        System.out.println("a <= b : " + (a <= b));     // true
        System.out.println("a >= b : " + (a >= b));     // false

        System.out.println("\n---- Relational Operators with Doubles ----");
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x == y : " + (x == y));     // false
        System.out.println("x != y : " + (x != y));     // true
        System.out.println("x < y  : " + (x < y));      // false
        System.out.println("x > y  : " + (x > y));      // true
        System.out.println("x <= y : " + (x <= y));     // false
        System.out.println("x >= y : " + (x >= y));     // true

        System.out.println("\n---- Mixed Type Comparison (int and double) ----");
        System.out.println("a = " + a + ", x = " + x);
        System.out.println("a == x : " + (a == x));     // false (10 != 15.5)
        System.out.println("a < x  : " + (a < x));      // true
        System.out.println("b > x  : " + (b > x));      // true (20 > 15.5)

        System.out.println("\n---- Key Notes ----");
        System.out.println("- Relational operators return boolean values: true or false.");
        System.out.println("- They can be used to compare both int and double types.");
        System.out.println("- Mixed-type comparisons (int vs double) are allowed in Java.");
    }
}

