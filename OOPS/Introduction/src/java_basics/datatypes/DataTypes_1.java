package java_basics.datatypes;

public class DataTypes_1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        // To store whole numbers from -128 to 127, use byte (1 byte = 8 bits)
        byte age = 109;
        System.out.println(age);  // Output: 109

        // To store whole numbers from -32,768 to 32,767, use short (2 bytes = 16 bits)
        short employeeCount = 1088;
        System.out.println(employeeCount);  // Output: 1088

        // To store whole numbers from -2^31 to 2^31 - 1, use int (4 bytes = 32 bits)
        int population = 1929338;
        System.out.println(population);  // Output: 1929338

        // To store whole numbers from -2^63 to 2^63 - 1, use long (8 bytes = 64 bits)
        long distanceInMeters = 483948332L;  // 'L' specifies it's a long literal
        System.out.println(distanceInMeters);  // Output: 483948332

        // To store decimal numbers with 6 to 7 digits of precision, use float (4 bytes = 32 bits)
        float itemPrice = 4.1234567f;  // 'f' is required for float literals
        System.out.println(itemPrice);  // Output: 4.1234565 (approximate)

        // To store decimal numbers with 15-16 digits of precision, use double (8 bytes = 64 bits)
        double piApproximation = 3.141592653589793;
        System.out.println(piApproximation);  // Output: 3.141592653589793

        // To store a single character, use char (2 bytes = 16 bits, stores Unicode characters)
        char initial = 'A';
        System.out.println(initial);  // Output: A

        // To store true or false values, use boolean (size depends on JVM implementation)
        boolean isJavaFun = true;
        System.out.println(isJavaFun);  // Output: true
    }
}
