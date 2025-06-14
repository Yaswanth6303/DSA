package onanswers;

public class KokoEatingBananas_4 {
    private long calculateTotalHours(int[] nums, int hourly) {
        long totalHours = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            totalHours += Math.ceil((double) nums[i] / (double) hourly);
        }
        return totalHours;
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
     * Time Complexity: O(maximum * n)
     * Space Complexity: O(1)
     */
    public int minimumRateToEatBananasBrute(int[] nums, int hours) {
        int maximum = maximum(nums);

        for (int i = 1; i <= maximum; i++) {
            long requiredTime = calculateTotalHours(nums, i);
            if (requiredTime <= (long) hours) {
                return i;
            }
        }

        return maximum;
    }
    /**
     * Time Complexity: O(log(maximum) * n)
     * Space Complexity: O(1)
     */
    public int minimumRateToEatBananasOptimal(int[] nums, int hours) {
        int low = 0;
        int high = maximum(nums);

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long requiredTime = calculateTotalHours(nums, mid);
            if (requiredTime <= hours) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        KokoEatingBananas_4 kokoEatingBananas4 = new KokoEatingBananas_4();
        int[] nums = {3, 6, 7, 11};
        int hours = 8;

        int kokoEatingBananasBrute = kokoEatingBananas4.minimumRateToEatBananasBrute(nums, hours);
        System.out.println("Koko should eat at least " + kokoEatingBananasBrute + " bananas/hr.");

        int kokoEatingBananasOptimal = kokoEatingBananas4.minimumRateToEatBananasOptimal(nums.clone(), hours);
        System.out.println("Koko should eat at least " + kokoEatingBananasOptimal + " bananas/hr.");
    }
}
