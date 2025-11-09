package slidingwindowalgorithms;

public class SubArrays_3 {

    // Function to find the number of subarrays with exactly sum target
    public int numSubarraysWithSum(int[] nums, int target) {
        return atMost(nums, target) - atMost(nums, target - 1);
    }

    // Helper function to find the number of subarrays with at most sum target
    private int atMost(int[] nums, int target) {
        if (target < 0) return 0;
        int result = 0, i = 0;

        // Sliding window approach to count subarrays
        for (int j = 0; j < nums.length; j++) {
            // Include A[j] in the current window
            target -= nums[j];
            while (target < 0) {
                // Shrink the window if the sum exceeds S
                target += nums[i++];
            }
            // Count all subarrays ending at j
            result += j - i + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        SubArrays_3 sol = new SubArrays_3();
        int[] nums = {1, 0, 1, 0, 1}; // Example array
        int target = 2; // Desired sum
        int result = sol.numSubarraysWithSum(nums, target);
        System.out.println("Number of subarrays with sum " + target + ": " + result);
    }
}
