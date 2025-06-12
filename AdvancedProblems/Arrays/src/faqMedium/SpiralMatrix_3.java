package faqMedium;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_3 {
    /**
     * Time Complexity -> O(n * m)
     * Space Complexity -> O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> spiralList = new ArrayList<>();
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        while (left <= right && top <= bottom) {
            // Top row
            for (int i = left; i <= right; i++) {
                spiralList.add(matrix[top][i]);
            }
            top++;

            // Right column
            for (int i = top; i <= bottom; i++) {
                spiralList.add(matrix[i][right]);
            }
            right--;

            // Bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiralList.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralList.add(matrix[i][left]);
                }
                left++;
            }
        }

        return spiralList;
    }
    public static void main(String[] args) {
        SpiralMatrix_3 spiralMatrix3 = new SpiralMatrix_3();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> spiralList = spiralMatrix3.spiralOrder(matrix);
        System.out.println("Spiral Matrix: ");
        HelperMethods.printList(spiralList);
    }
}
