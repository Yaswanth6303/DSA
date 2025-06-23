package faqs;

public class SplitArrayLargestSum_7 {
    private int countPartitions(int[] nums, int maxSum) {
        int n = nums.length;
        int partitions = 1;
        long subarraySum = 0;

        for (int i = 0; i < n; i++) {
            if (subarraySum + nums[i] <= maxSum) {
                subarraySum += nums[i];
            } else {
                partitions++;
                subarraySum = nums[i];
            }
        }

        return partitions;
    }
    public int largestSubArraySumMinimized(int[] nums, int k) {

        // Initialize binary search boundaries
        int low = nums[0];
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(nums, mid);

            if (partitions > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return low;
    }
    public static void main (String[] args) {
        SplitArrayLargestSum_7 solver = new SplitArrayLargestSum_7();
        int[] nums = {10, 20, 30, 40};
        int k = 2;

        int result = solver.largestSubArraySumMinimized(nums, k);
        System.out.println("The minimized largest sum of the split is: " + result);
    }
}
