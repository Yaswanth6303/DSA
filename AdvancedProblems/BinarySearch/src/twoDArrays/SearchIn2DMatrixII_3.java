package twoDArrays;

public class SearchIn2DMatrixII_3 {
    public boolean binarySearch(int[] nums, int target) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
    /**
     * Time Complexity: O(n * log m)
     * Space Complexity: O(1)
     */
    public boolean searchMatrixBrute(int[][] matrix, int target) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            boolean flag =  binarySearch(matrix[i], target);
            if (flag) return true;
        }

        return false;
    }
    /**
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else col--;
        }

        return false;
    }
    public static void main(String[] args) {
        SearchIn2DMatrixII_3 solution = new SearchIn2DMatrixII_3();

        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target1 = 5;
        int target2 = 20;

        System.out.println("Brute Force (target = 5): " + solution.searchMatrixBrute(matrix, target1));
        System.out.println("Optimal Approach (target = 5): " + solution.searchMatrixOptimal(matrix, target1));

        System.out.println("Brute Force (target = 20): " + solution.searchMatrixBrute(matrix, target2));
        System.out.println("Optimal Approach (target = 20): " + solution.searchMatrixOptimal(matrix, target2));
    }

}
