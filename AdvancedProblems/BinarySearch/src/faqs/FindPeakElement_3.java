package faqs;

public class FindPeakElement_3 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findPeakElementBrute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i] > nums[i - 1]) && (i == n - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }

        return -1;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findPeakElementOptimal(int[] nums) {
        int n = nums.length;
        int result = -1;

        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                result = mid;
                break; // Found a peak, exit loop
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        FindPeakElement_3 finder = new FindPeakElement_3();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 5, 1};

        int bruteIndex = finder.findPeakElementBrute(nums);
        int optimalIndex = finder.findPeakElementOptimal(nums);

        System.out.println("Brute Force Peak Index: " + bruteIndex + " (Value: " + nums[bruteIndex] + ")");
        System.out.println("Optimal Peak Index: " + optimalIndex + " (Value: " + nums[optimalIndex] + ")");
    }
}
