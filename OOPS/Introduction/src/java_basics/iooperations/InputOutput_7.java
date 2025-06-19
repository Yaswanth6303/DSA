package java_basics.iooperations;

import java.util.Scanner;

public class InputOutput_7 {
    public static void main(String[] args) {
        // Create a Scanner object to take input from the user
        Scanner scanner = new Scanner(System.in);

        // Integer input
        System.out.print("Enter your age (int): ");
        int age = scanner.nextInt();
        System.out.println("Your age is: " + age);

        // Double input
        System.out.print("Enter your height in cm (double): ");
        double height = scanner.nextDouble();
        System.out.println("Your height is: " + height + " cm");

        // Boolean input
        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();
        System.out.println("Student status: " + isStudent);

        // To consume the leftover newline from nextBoolean()
        scanner.nextLine();

        // String input using next() – reads only one word (stops at space)
        System.out.print("Enter your first name (next): ");
        String firstName = scanner.next();
        System.out.println("First name is: " + firstName);

        // Consume the leftover newline again if needed
        scanner.nextLine();

        // String input using nextLine() – reads the whole line (including spaces)
        System.out.print("Enter your full name (nextLine): ");
        String fullName = scanner.nextLine();
        System.out.println("Full name is: " + fullName);

        scanner.close();  // Always close the scanner
    }
}

