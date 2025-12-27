package substringProblems;

public class CountSubArraysNiceNumbers_3 {
    public int numberOfOddSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
    private int helper(int[] nums, int goal) {
        if (goal < 0) return 0;
        int l = 0;
        int sum = 0;
        int count = 0;
        int n = nums.length;

        for (int r = 0; r < n; r++) {
            sum += nums[r] % 2;

            while (sum > goal) {
                sum -= nums[l] % 2;
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }
    static void main() {
        CountSubArraysNiceNumbers_3 obj = new CountSubArraysNiceNumbers_3();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int result = obj.numberOfOddSubarrays(nums, k);
        System.out.println("Number of nice subarrays with \"" + k + "\" odd numbers is: " + result);
    }
}
