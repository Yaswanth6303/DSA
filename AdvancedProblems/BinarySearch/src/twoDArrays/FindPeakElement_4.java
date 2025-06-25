package twoDArrays;

import java.util.Arrays;

public class FindPeakElement_4 {
    /**
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public int[] findPeakGridBrute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxValue = Integer.MIN_VALUE;
        int[] maxValueIndex = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    maxValueIndex[0] = i;
                    maxValueIndex[1] = j;
                }
            }
        }

        return maxValueIndex;
    }
    public int maxElement(int[][] matrix, int columnNumber) {
        int n = matrix.length;
        int maxElement = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (matrix[i][columnNumber] > maxElement) {
                maxElement = matrix[i][columnNumber];
                index = i;
            }
        }

        return index;
    }
    /**
     * Time Complexity: O(n * log m)
     * Space Complexity: O(1)
     */
    public int[] findPeakGridOptimal(int[][] matrix) {
        int m = matrix[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int rowNumber = maxElement(matrix, mid);
            int current = matrix[rowNumber][mid];

            int left = (mid - 1 >= 0) ? matrix[rowNumber][mid - 1] : -1;
            int right = (mid + 1 < m) ? matrix[rowNumber][mid + 1] : -1;

            if (left > current) {
                high = mid - 1;
            } else if (right > current) {
                low = mid + 1;
            } else {
                return new int[]{ rowNumber, mid };
            }
        }

        return new int[]{ -1, -1 };
    }

    public static void main(String[] args) {
        FindPeakElement_4 finder = new FindPeakElement_4();

        int[][] matrix = {
                {4, 2, 5, 1, 4, 5},
                {2, 9, 3, 2, 3, 2},
                {1, 7, 6, 0, 1, 3},
                {3, 6, 2, 3, 7, 2}
        };

        System.out.println("Testing Brute Force Method:");
        int[] bruteResult = finder.findPeakGridBrute(matrix);
        System.out.println("Peak (Brute): " + Arrays.toString(bruteResult) +
                ", Value: " + matrix[bruteResult[0]][bruteResult[1]]);

        System.out.println("\nTesting Optimal Binary Search Method:");
        int[] optimalResult = finder.findPeakGridOptimal(matrix);
        System.out.println("Peak (Optimal): " + Arrays.toString(optimalResult) +
                ", Value: " + matrix[optimalResult[0]][optimalResult[1]]);
    }
}

// There may be multiple — just one valid peak is enough.