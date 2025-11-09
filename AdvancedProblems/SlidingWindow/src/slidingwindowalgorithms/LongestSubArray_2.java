package slidingwindowalgorithms;

public class LongestSubArray_2 {
    public static  void longestSubArraysBrute(int[] nums, int k) {
        int n = nums.length;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                } else {
                    break;
                }
            }
        }

        System.out.println("Longest subarray length with sum ≤ " + k + " is(Brute): " + maxLength);
    }
    public static void longestSubArraysOptimal(int[] nums, int k) {
        // l, r -> These are windows
        // l -> Shrinks
        // r -> Expands (till n - 1)
        int n = nums.length;
        int l = 0;
        int sum = 0;
        int maxLength = 0;

        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while (sum > k) {
                sum -= nums[l];
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

        System.out.println("Longest subarray length with sum ≤ " + k + " is(Optimal): " + maxLength);
    }
    static void main() {
        int[] nums = {2, 5, 1, 10, 10};
        int k = 14;
        longestSubArraysBrute(nums, k);
        longestSubArraysOptimal(nums, k);
    }
}