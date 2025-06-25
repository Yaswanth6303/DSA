package twoDArrays;

public class SearchIn2DMatrixI_2 {
    /**
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    public boolean searchMatrixBrute(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
    /**
     * Time Complexity: O(n + log m)
     * Space Complexity: O(1)
     */
    public boolean searchMatrixBetter(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

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
     * Time Complexity: O(log(n * m))
     * Space Complexity: O(1)
     */
    public boolean searchMatrixOptimal(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / m;
            int col = mid % m;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
    public static void main(String[] args) {
        SearchIn2DMatrixI_2 solution = new SearchIn2DMatrixI_2();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 16;

        System.out.println("Brute Force: " + solution.searchMatrixBrute(matrix, target));
        System.out.println("Better Approach: " + solution.searchMatrixBetter(matrix, target));
        System.out.println("Optimal Approach: " + solution.searchMatrixOptimal(matrix, target));
    }
}
