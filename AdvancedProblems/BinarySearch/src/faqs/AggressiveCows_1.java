package faqs;

import java.util.Arrays;

public class AggressiveCows_1 {
    private boolean canWePlace(int[] nums, int distance, int cows) {
        int n = nums.length;
        int lastCowPlaced = nums[0];
        int countCowsPlaced = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] - lastCowPlaced >= distance) {
                countCowsPlaced++;
                lastCowPlaced = nums[i];
            }

            if (countCowsPlaced >= cows) return true;
        }

        return false;
    }
    /**
     * Time Complexity: O(n log n) + O(limit * n)
     * Space Complexity: O(1)
     */
    public int aggressiveCowsLinearSearch(int[] nums, int cows) {
        int n = nums.length;
        Arrays.sort(nums);

        int limit = nums[n - 1] - nums[0];
        for (int i = 1; i <= limit; i++) {
            if (canWePlace(nums, i, cows)) {
                continue;
            } else {
                return i - 1;
            }
        }

        return limit;
    }
    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public int aggressiveCowsBinarySearch(int[] nums, int cows) {
        int n = nums.length;
        int low = 1;
        Arrays.sort(nums);
        int high = nums[n - 1] - nums[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canWePlace(nums, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
    public static void main(String[] args) {
        AggressiveCows_1 solver = new AggressiveCows_1();
        int[] nums = {0, 3, 4, 7, 9, 10};
        int cows = 4;

        int maxDistanceBrute = solver.aggressiveCowsLinearSearch(nums, cows);
        System.out.println("Maximum distance is (Brute): " + maxDistanceBrute);

        int maxDistanceOptimal = solver.aggressiveCowsBinarySearch(nums.clone(), cows);
        System.out.println("Maximum distance is (Optimal): " + maxDistanceOptimal);
    }
}
