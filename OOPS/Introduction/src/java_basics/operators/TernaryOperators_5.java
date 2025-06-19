package java_basics.operators;

public class TernaryOperators_5 {
    public static void main(String[] args) {
        // Integer values
        int a = 10;
        int b = 20;

        // Double values
        double x = 15.5;
        double y = 10.0;

        System.out.println("---- Ternary Operator with Integers ----");
        String result1 = (a > b) ? "a is greater than b" : "a is not greater than b";
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Result: " + result1);  // Output: a is not greater than b

        int maxInt = (a > b) ? a : b;
        System.out.println("Maximum (int): " + maxInt);  // Output: 20

        System.out.println("\n---- Ternary Operator with Doubles ----");
        String result2 = (x < y) ? "x is less than y" : "x is not less than y";
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("Result: " + result2);  // Output: x is not less than y

        double minDouble = (x < y) ? x : y;
        System.out.println("Minimum (double): " + minDouble);  // Output: 10.0

        System.out.println("\n---- Ternary Operator for Even or Odd ----");
        String evenOrOdd = (a % 2 == 0) ? "Even" : "Odd";
        System.out.println("a = " + a + " is " + evenOrOdd);  // Output: Even

        System.out.println("\n---- Ternary with Boolean Condition ----");
        boolean isJavaFun = true;
        String javaStatus = isJavaFun ? "Java is fun!" : "Java is boring!";
        System.out.println("isJavaFun = " + isJavaFun);
        System.out.println("Result: " + javaStatus);  // Output: Java is fun!

        System.out.println("\n---- Key Notes ----");
        System.out.println("- Ternary operator is a shorthand for if-else.");
        System.out.println("- Syntax: condition ? true_result : false_result;");
        System.out.println("- It works with int, double, String, boolean, etc.");
    }
}
