package java_basics.strings;

public class StringOperations_6 {
    public static void main(String[] args) {
        // Original String
        String name = "Yaswanth";

        System.out.println("---- charAt() Method ----");
        // Returns the character at the specified index (0-based)
        char firstChar = name.charAt(0);
        System.out.println("First character of '" + name + "' is: " + firstChar);  // Output: Y

        System.out.println("\n---- length() Method ----");
        int nameLength = name.length();
        System.out.println("Length of '" + name + "' is: " + nameLength);  // Output: 8

        System.out.println("\n---- substring() Method ----");
        String sub1 = name.substring(0, 3);  // From index 0 to 2 (end index is exclusive)
        System.out.println("Substring(0, 3): " + sub1);  // Output: Yas

        String sub2 = name.substring(3);  // From index 3 to end
        System.out.println("Substring(3): " + sub2);  // Output: wanth

        System.out.println("\n---- String Concatenation ----");
        String lastName = "Gudivada";
        String fullName = name + " " + lastName;  // Using + operator
        System.out.println("Full Name (using +): " + fullName);  // Output: Yaswanth Gudivada

        String fullName2 = name.concat(" ").concat(lastName);  // Using concat()
        System.out.println("Full Name (using concat()): " + fullName2);  // Output: Yaswanth Gudivada

        System.out.println("\n---- equals() Method ----");
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println("s1 == s2: " + (s1 == s2));         // true → same reference in String Pool
        System.out.println("s1 == s3: " + (s1 == s3));         // false → different objects
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true → compares actual content

        System.out.println("\n---- String Immutability ----");
        String original = "Hello";
        String modified = original.concat(" World");

        System.out.println("Original: " + original);  // Output: Hello
        System.out.println("Modified: " + modified);  // Output: Hello World
        // Even after concatenation, original string remains unchanged → Strings are immutable

        System.out.println("\n---- How Java Stores Strings ----");
        String str1 = "Code";         // Stored in String Pool
        String str2 = "Code";         // Points to same object as str1
        String str3 = new String("Code");  // Creates a new object in heap

        System.out.println("str1 == str2: " + (str1 == str2));     // true → same reference in pool
        System.out.println("str1 == str3: " + (str1 == str3));     // false → different objects
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true → same value

        System.out.println("\n---- Key Notes ----");
        System.out.println("- Strings in Java are immutable (cannot be changed after creation).");
        System.out.println("- '+' operator or concat() creates a new string object.");
        System.out.println("- String literals are stored in the String Pool.");
        System.out.println("- '==' compares reference (memory address), 'equals()' compares content.");
    }
}

