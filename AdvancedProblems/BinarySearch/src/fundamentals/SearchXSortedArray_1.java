package fundamentals;

public class SearchXSortedArray_1 {
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int searchIterative(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
    public int binarySearchRecursive(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] == target) return mid;
        else if (target < nums[mid]) return binarySearchRecursive(nums, low, mid - 1, target);
        else return binarySearchRecursive(nums, mid + 1, high, target);
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public int searchRecursive(int[] nums, int target) {
        return binarySearchRecursive(nums, 0, nums.length - 1, target);
    }
    public static void main(String[] args) {
        SearchXSortedArray_1 solver = new SearchXSortedArray_1();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 2;

        int iterativeSolution = solver.searchIterative(nums, target);
        System.out.print("Binary Search Iterative: ");
        System.out.println(iterativeSolution);


        int recursiveSolution = solver.searchRecursive(nums.clone(), target);
        System.out.print("Binary Search Recursive: ");
        System.out.println(recursiveSolution);
    }
}
