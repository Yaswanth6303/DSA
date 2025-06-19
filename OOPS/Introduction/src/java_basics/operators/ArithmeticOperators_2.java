package java_basics.operators;

public class ArithmeticOperators_2 {
    public static void main(String[] args) {
        // Integer values
        int a = 10;
        int b = 3;

        // Double values
        double x = 10.0;
        double y = 3.0;

        System.out.println("---- Integer Operations ----");
        System.out.println("Addition (int): " + (a + b));        // 10 + 3 = 13
        System.out.println("Subtraction (int): " + (a - b));     // 10 - 3 = 7
        System.out.println("Multiplication (int): " + (a * b));  // 10 * 3 = 30
        System.out.println("Division (int): " + (a / b));        // 10 / 3 = 3 (integer division)
        System.out.println("Modulus (int): " + (a % b));         // 10 % 3 = 1

        System.out.println("\n---- Double Operations ----");
        System.out.println("Addition (double): " + (x + y));        // 10.0 + 3.0 = 13.0
        System.out.println("Subtraction (double): " + (x - y));     // 10.0 - 3.0 = 7.0
        System.out.println("Multiplication (double): " + (x * y));  // 10.0 * 3.0 = 30.0
        System.out.println("Division (double): " + (x / y));        // 10.0 / 3.0 = 3.333...
        System.out.println("Modulus (double): " + (x % y));         // 10.0 % 3.0 = 1.0

        System.out.println("\n---- Key Differences ----");
        System.out.println("Integer division discards decimals. Example: 10 / 3 = " + (a / b));
        System.out.println("Double division keeps decimal precision. Example: 10.0 / 3.0 = " + (x / y));
    }
}

