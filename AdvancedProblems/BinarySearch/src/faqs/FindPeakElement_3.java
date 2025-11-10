package faqs;

public class FindPeakElement_3 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findPeakElementBrute_1(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i] > nums[i - 1]) && (i == n - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }

        return -1;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findPeakElementBrute_2(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == n - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else {
                if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                    return i;
                }
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

        int bruteIndex_1 = finder.findPeakElementBrute_1(nums);
        int bruteIndex_2 = finder.findPeakElementBrute_2(nums);
        int optimalIndex = finder.findPeakElementOptimal(nums);

        System.out.println("Brute Force 1 Peak Index: " + bruteIndex_1 + " (Value: " + nums[bruteIndex_1] + ")");
        System.out.println("Brute Force 2 Peak Index: " + bruteIndex_2 + " (Value: " + nums[bruteIndex_2] + ")");
        System.out.println("Optimal Peak Index: " + optimalIndex + " (Value: " + nums[optimalIndex] + ")");
    }
}

/**
 * Try For these examples also
 * 1) 1, 10, 13, 7, 6, 5, 4, 2, 1, 0
 * 2) 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
 * 3) 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
 * 4) 1, 5, 1, 2, 1
 */