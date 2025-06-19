package logicBuilding;

public class SearchInRotatedArrayI_4 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int searchLinearSearch(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int searchBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] < target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        SearchInRotatedArrayI_4 solver = new SearchInRotatedArrayI_4();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int searchLinearSearch = solver.searchLinearSearch(nums, target);
        System.out.print("Search in rotated array(Linear Search): ");
        System.out.println(searchLinearSearch);

        int searchBinarySearch = solver.searchBinarySearch(nums.clone(), target);
        System.out.print("Search in rotated array(Binary Search): ");
        System.out.println(searchBinarySearch);
    }
}
