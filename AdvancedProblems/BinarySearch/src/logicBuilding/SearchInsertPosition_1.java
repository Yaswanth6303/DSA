package logicBuilding;

public class SearchInsertPosition_1 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int searchInsertBrute(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return n;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int searchInsertOptimal(int[] nums, int target) {
        int n = nums.length;
        int insertIndex = n;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                insertIndex = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return insertIndex;
    }
    public static void main(String[] args) {
        SearchInsertPosition_1 solver = new SearchInsertPosition_1();
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int insertIndexBrute = solver.searchInsertBrute(nums, target);
        System.out.print("Insert index Brute: ");
        System.out.println(insertIndexBrute);

        int insertIndexOptimal = solver.searchInsertOptimal(nums.clone(), target);
        System.out.print("Insert index Optimal: ");
        System.out.println(insertIndexOptimal);
    }
}
