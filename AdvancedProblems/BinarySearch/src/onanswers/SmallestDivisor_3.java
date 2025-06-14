package onanswers;

public class SmallestDivisor_3 {
    /**
     * Time Complexity: O(maximum * n)
     * Space Complexity: O(1)
     */
    public int smallestDivisorBrute(int[] nums, int limit) {
        int n = nums.length;
        int maximum = maximum(nums);

        for (int d = 1; d <= maximum; d++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) nums[i] / (double) d);
            }

            if (sum <= limit) return d;
        }
        return -1;
    }
    public int sumByD(int[] nums, int limit) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)nums[i] / (double)limit);
        }
        return sum;
    }
    public int maximum(int[] nums) {
        int n = nums.length;

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }

        return maxValue;
    }
    /**
     * Time Complexity: O(log(maximum) * n)
     * Space Complexity: O(1)
     */
    public int smallestDivisorOptimal(int[] nums, int limit) {
        int n = nums.length;
        if (n > limit) return -1;

        int maximum = maximum(nums);

        int low = 0;
        int high = maximum;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sumByD(nums, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        SmallestDivisor_3 smallestDivisor3 = new SmallestDivisor_3();
        int[] nums = {1, 2, 5, 9};
        int limit = 6;

        int smallestDivisorBrute = smallestDivisor3.smallestDivisorBrute(nums, limit);
        System.out.print("Smallest Divisor Brute: ");
        System.out.println(smallestDivisorBrute);

        int smallestDivisorOptimal = smallestDivisor3.smallestDivisorOptimal(nums.clone(), limit);
        System.out.print("Smallest Divisor Optimal: ");
        System.out.println(smallestDivisorOptimal);
    }
}
