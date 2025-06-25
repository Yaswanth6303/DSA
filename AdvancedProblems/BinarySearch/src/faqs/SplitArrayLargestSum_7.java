package faqs;

public class SplitArrayLargestSum_7 {
    /**
     * Time Complexity: O(n * log(sum - max))
     *   - n = length of array
     *   - log(sum - max): binary search range
     *
     * Space Complexity: O(1)
     */

    public int splitArray(int[] nums, int k) {
        int[] sumAndMax = findMaxAndSum(nums);
        int low = sumAndMax[0]; // max of nums
        int high = sumAndMax[1]; // sum of nums
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (countSubArrays(nums, mid) <= k) {
                result = mid;
                high = mid - 1; // try smaller max
            } else {
                low = mid + 1; // too many splits, increase limit
            }
        }

        return result;
    }
    public int[] findMaxAndSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        return new int[]{max, sum};
    }
    public int countSubArrays(int[] nums, int maxAllowedSum) {
        int n = nums.length;
        int subarrays = 1;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            if (currentSum + nums[i] <= maxAllowedSum) {
                currentSum += nums[i];
            } else {
                subarrays++;
                currentSum = nums[i];
            }
        }

        return subarrays;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum_7 solution = new SplitArrayLargestSum_7();

        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;

        int result = solution.splitArray(nums, k);
        System.out.println("Minimum possible largest sub-array sum: " + result);
    }
}
