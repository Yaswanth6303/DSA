package faqMedium;

import fundamentals.HelperMethods;

public class RotateMatrix_7 {
    public void rotateMatrixBrute(int[][] matrix) {
        int n = matrix.length;

        int[][] rotatedMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(rotatedMatrix[i], 0, matrix[i], 0, n);
        }
    }
    public void transpose(int[][] matrix, int r, int c) {
        for (int i = 0; i < c; i++) {
            for (int j = i; j < r; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public void reverse(int[] nums) {
        int n = nums.length;
        int firstIndex = 0;
        int lastIndex = n - 1;
        while (firstIndex < lastIndex) {
            int temp = nums[firstIndex];
            nums[firstIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            firstIndex++;
            lastIndex--;
        }
    }
    public void rotateMatrixOptimal1(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix, n, n);
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }
    public void rotateMatrixOptimal2(int[][] matrix) {
        int n = matrix.length;
        // Outer loop: i goes from 0 to n - 2 (i.e., 0 to 1 when n = 3)
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: for each i, j goes from i + 1 to n - 1
            // Example when n = 3:
            // i = 0 --> j = 1, 2 (matrix[0][1], matrix[0][2])
            // i = 1 --> j = 2     (matrix[1][2])
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
    }
    public static void main(String[] args) {
        RotateMatrix_7 rotateMatrix7 = new RotateMatrix_7();
        int[][] matrix_1 = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        System.out.println("Rotated Matrix Brute: ");
        rotateMatrix7.rotateMatrixBrute(matrix_1);
        HelperMethods.printMatrix(matrix_1);

        int[][] matrix_2 = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        System.out.println("Rotated Matrix Optimal-1: ");
        rotateMatrix7.rotateMatrixOptimal1(matrix_2);
        HelperMethods.printMatrix(matrix_2);

        int[][] matrix_3 = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        System.out.println("Rotated Matrix Optimal-2: ");
        rotateMatrix7.rotateMatrixOptimal2(matrix_3);
        HelperMethods.printMatrix(matrix_3);
    }
}
