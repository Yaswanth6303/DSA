package faqMedium;

import fundamentals.HelperMethods;

public class PascalTriangleII_5 {
    /**
     * Time Complexity:
     * -> The loop runs from c = 1 to r
     * -> For each iteration, it calls nCr(r - 1, c - 1), which takes O(r) time
     * -> So total time = r * O(r) = O(r^2)

     * Space Complexity: O(1)
     */
    public void pascalTriangleBrute(int r) {
        System.out.println("Pascal triangle(Brute) for row " + r + " is: ");
        for (int c = 1; c <= r; c++) {
            int value = PascalTriangleI_4.nCr(r - 1, c - 1);
            System.out.print(value + " ");
        }
        System.out.println();
    }
    /**
     * Time Complexity: O(r)
     * Space Complexity: O(1)
     */
    public void pascalTriangleIIOptimal_1(int row) {
        int result = 1;
        System.out.println("Pascal triangle(Optimal_1) for row " + row + " is: ");
        System.out.print(result + " ");
        for (int col = 1; col < row; col++) {
            result = result * (row - col) / col;
            System.out.print(result + " ");
        }
        System.out.println();
    }
    /**
     * Time Complexity: O(r)
     * Space Complexity: O(r)
     */
    public int[] pascalTriangleIIOptimal_2 (int r) {
        int[] pascalArray = new int[r];
        pascalArray[0] = 1;

        for (int c = 1; c < r; c++) {
            pascalArray[c] = (pascalArray[c - 1] * (r - c)) / c;
        }

        return pascalArray;
    }
    public static void main(String[] args) {
        PascalTriangleII_5 pascalTriangleII5 = new PascalTriangleII_5();
        int r = 3;

        pascalTriangleII5.pascalTriangleBrute(r);
        pascalTriangleII5.pascalTriangleIIOptimal_1(r);
        System.out.println("Pascal triangle(Optimal_1) for row " + r + " is: ");
        int[] pascalTriangleOptimal = pascalTriangleII5.pascalTriangleIIOptimal_2(r);
        HelperMethods.printArray(pascalTriangleOptimal);
    }
}
