package java_basics.typecasting;

public class TypeCasting_8 {
    public static void main(String[] args) {

        System.out.println("---- Implicit Type Casting (Widening) ----");

        int intVal = 100;
        double doubleVal = intVal;  // int to double
        System.out.println("int value: " + intVal);
        System.out.println("Converted to double: " + doubleVal);

        char charVal = 'A';
        int charToInt = charVal;  // char to int (Unicode value)
        System.out.println("char value: " + charVal);
        System.out.println("Converted to int (Unicode): " + charToInt);

        float floatVal = 45.67f;
        double floatToDouble = floatVal;  // float to double
        System.out.println("float value: " + floatVal);
        System.out.println("Converted to double: " + floatToDouble);


        System.out.println("\n---- Explicit Type Casting (Narrowing) ----");

        double dVal = 99.99;
        int dToInt = (int) dVal;  // double to int (decimal is truncated)
        System.out.println("double value: " + dVal);
        System.out.println("Converted to int (truncated): " + dToInt);

        int bigInt = 300;
        byte intToByte = (byte) bigInt;  // int to byte (value overflow)
        System.out.println("int value: " + bigInt);
        System.out.println("Converted to byte (overflow): " + intToByte);

        int ascii = 66;
        char intToChar = (char) ascii;  // int to char (Unicode character)
        System.out.println("int value: " + ascii);
        System.out.println("Converted to char: " + intToChar);  // Output: B

        System.out.println("\n---- Key Notes ----");
        System.out.println("- Implicit casting happens automatically when converting smaller to larger types (e.g., int → double).");
        System.out.println("- Explicit casting is required when converting larger to smaller types (e.g., double → int).");
        System.out.println("- Explicit casting can result in data loss or overflow.");
    }
}
