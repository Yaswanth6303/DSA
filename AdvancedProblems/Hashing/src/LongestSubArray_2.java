import java.util.HashMap;
import java.util.Map;

public class LongestSubArray_2 {
    /**
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int longestSubArrayBrute(int[] nums, int target) {
        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                if (sum == target) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int longestSubArrayBetter(int[] nums, int target) {
        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == target) {
                    maxLength = Math.max(maxLength ,j - i + 1);
                }
            }
        }

        return maxLength;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    // For Positives and Negatives
    public int longestSubArrayOptimal1(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == target) {
                maxLength = Math.max(maxLength, i + 1); // i + 1 because 0 based indexing
            }

            int remainder = sum - target;
            if (mpp.containsKey(remainder)) {
                int length = i - mpp.get(remainder);
                maxLength = Math.max(length, maxLength);
            }

            if (!mpp.containsKey(sum)) { // To handle unique sum values
                mpp.put(sum, i);
            }
        }

        return maxLength;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int longestSubArrayOptimal2(int[] nums, int target) {
        int n = nums.length;
        int longest = 0;

        int sum = 0;
        int j = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // Shrink the window until sum <= target
            while (sum > target && j <= i) {
                sum -= nums[j];
                j++;
            }

            // Check if current window equals target
            if (sum == target) {
                longest = Math.max(longest, i - j + 1);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestSubArray_2 longestSubArray2 = new LongestSubArray_2();
        int[] nums = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int target = 3;

        int longestSubArrayBrute = longestSubArray2.longestSubArrayBrute(nums, target);
        System.out.print("Longest Sub-array Brute: ");
        System.out.println(longestSubArrayBrute);

        int longestSubArrayBetter = longestSubArray2.longestSubArrayBetter(nums, target);
        System.out.print("Longest Sub-array Better: ");
        System.out.println(longestSubArrayBetter);

        int longestSubArrayOptimalPosAndNeg = longestSubArray2.longestSubArrayOptimal1(nums, target);
        System.out.print("Longest Sub-array Optimal (Positives and Negatives): ");
        System.out.println(longestSubArrayOptimalPosAndNeg);

        int[] nums1 = {2, 0, 0, 3};
        int longestSubArrayOptimalPosAndNeg_1 = longestSubArray2.longestSubArrayOptimal1(nums1, target);
        System.out.print("Longest Sub-array Optimal (Positives and Negatives): ");
        System.out.println(longestSubArrayOptimalPosAndNeg_1);

        int longestSubArrayOptimalPos = longestSubArray2.longestSubArrayOptimal2(nums, target);
        System.out.print("Longest Sub-array Optimal (Positives): ");
        System.out.println(longestSubArrayOptimalPos);
    }
}
