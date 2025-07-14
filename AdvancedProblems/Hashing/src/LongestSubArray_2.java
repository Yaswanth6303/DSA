import java.util.HashMap;
import java.util.Map;

public class LongestSubArray_2 {

    public static void printArray(int[] nums, int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    /**
     * Brute M1 - Just return longest length
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int longestSubArrayBruteM1(int[] nums, int target) {
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
     * Brute M2 - Print all subarrays with sum = target
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static int longestSubArrayBruteM2(int[] nums, int target) {
        int n = nums.length;
        int longest = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == target) {
                    printArray(nums, i, j);
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }

        return longest;
    }

    /**
     * Brute M3 - Print only longest subarray with sum = target
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public static int longestSubArrayBruteM3(int[] nums, int target) {
        int n = nums.length;
        int maxLength = 0;
        int start = -1, end = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                if (sum == target && (j - i + 1 > maxLength)) {
                    maxLength = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }

        if (start != -1 && end != -1) {
            printArray(nums, start, end);
        }

        return maxLength;
    }

    /**
     * Better - prefix sum in O(n^2)
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
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    /**
     * Optimal 1 - Works for positives + negatives
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int longestSubArrayOptimal1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == target) {
                maxLength = i + 1;
            }

            int remainder = sum - target;

            if (map.containsKey(remainder)) {
                maxLength = Math.max(maxLength, i - map.get(remainder));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    /**
     * Optimal 2 - Only works for non-negative integers
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
        LongestSubArray_2 solver = new LongestSubArray_2();

        int[] nums = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int target = 3;

        System.out.println("=== Brute Force M1 ===");
        System.out.println("Longest Length: " + solver.longestSubArrayBruteM1(nums, target));

        System.out.println("\n=== Brute Force M2 (All Matching Subarrays) ===");
        solver.longestSubArrayBruteM2(nums, target);

        System.out.println("\n=== Brute Force M3 (Longest Matching Subarray) ===");
        solver.longestSubArrayBruteM3(nums, target);

        System.out.println("\n=== Better Approach ===");
        System.out.println("Longest Length: " + solver.longestSubArrayBetter(nums, target));

        System.out.println("\n=== Optimal 1 (Positives & Negatives) ===");
        System.out.println("Longest Length: " + solver.longestSubArrayOptimal1(nums, target));

        System.out.println("\n=== Optimal 2 (Only Positives) ===");
        System.out.println("Longest Length: " + solver.longestSubArrayOptimal2(nums, target));

        System.out.println("\n=== Edge Case: [2, 0, 0, 3] ===");
        int[] nums1 = {2, 0, 0, 3};
        System.out.println("Optimal 1: " + solver.longestSubArrayOptimal1(nums1, target));
        System.out.println("Optimal 2: " + solver.longestSubArrayOptimal2(nums1, target));
    }
}
