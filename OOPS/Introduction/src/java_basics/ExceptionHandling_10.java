package java_basics;

import java.util.Scanner;

public class ExceptionHandling_10 {
    public static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking input
            System.out.print("Enter numerator (int): ");
            int num = scanner.nextInt();

            System.out.print("Enter denominator (int): ");
            int den = scanner.nextInt();

            // This may throw ArithmeticException
            int result = divide(num, den);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Exception: " + e);

        } finally {
            // Always executes
            System.out.println("Finally block executed. Closing resources if any...");
            scanner.close();
        }

        System.out.println("Program continues after exception handling...");
    }
}

