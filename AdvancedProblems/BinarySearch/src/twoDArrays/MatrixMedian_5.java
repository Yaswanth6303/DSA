package twoDArrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixMedian_5 {
    /**
     * Time Complexity: O(m * n) + O(M*N(log(m * n)))
     * Space Complexity: O(1)
     */
    public int findMedianBrute(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> flattenedList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flattenedList.add(matrix[i][j]);
            }
        }

        Collections.sort(flattenedList);
        return flattenedList.get((rows * cols) / 2);
    }
    public int upperBound(int[] row, int target, int cols) {
        int low = 0, high = cols - 1;
        int result = cols;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (row[mid] > target) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
    public int countSmallerOrEqual(int[][] matrix, int rows, int cols, int target) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            count += upperBound(matrix[i], target, cols);
        }

        return count;
    }
    /**
     * Time Complexity:  O(log(max)) * O(n(log m))
     * Space Complexity: O(1)
     */
    public int findMedianOptimal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][cols - 1]);
        }

        int requiredCount = (rows * cols) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int smallerOrEqualCount = countSmallerOrEqual(matrix, rows, cols, mid);

            if (smallerOrEqualCount <= requiredCount) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        MatrixMedian_5 medianFinder = new MatrixMedian_5();

        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };

        int bruteMedian = medianFinder.findMedianBrute(matrix);
        int optimalMedian = medianFinder.findMedianOptimal(matrix);

        System.out.println("Median using brute-force method: " + bruteMedian);
        System.out.println("Median using optimal method: " + optimalMedian);
    }
}
