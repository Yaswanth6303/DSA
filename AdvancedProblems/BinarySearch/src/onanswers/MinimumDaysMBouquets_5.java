package onanswers;

public class MinimumDaysMBouquets_5 {
    public int[] findMaxAndMin(int[] nums) {
        int n = nums.length;
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxValue = Math.max(nums[i], maxValue);
            minValue = Math.min(nums[i], minValue);
        }

        return new int[]{maxValue, minValue};
    }
    public boolean possible(int[] nums, int day, int k, int m) {
        int n = nums.length;
        int bloomedCount = 0;
        int numOfBouquets = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= day) {
                bloomedCount++;
            } else {
                numOfBouquets += (bloomedCount / k);
                bloomedCount = 0;
            }
        }
        numOfBouquets += (bloomedCount / k);

        return numOfBouquets >= m;
    }
    public int roseGardenBrute(int[] nums, int k, int m) {
        int n = nums.length;
        long minimumFlowers = (long) m * k;
        if (minimumFlowers > n) return -1;

        int[] findMaxMin = findMaxAndMin(nums);
        int min = findMaxMin[1];
        int max = findMaxMin[0];

        for (int i = min; i < max; i++) {
            if (possible(nums, i, k, m)) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        MinimumDaysMBouquets_5 solver = new MinimumDaysMBouquets_5();
        int[] nums = {7, 7, 7, 7, 13, 11, 12, 7};
        int m = 2; // Bouquets
        int k = 3; // Flowers

        int numberOfBouquetsBrute = solver.roseGardenBrute(nums, k, m);

        if (numberOfBouquetsBrute == -1) {
            System.out.println("We cannot make m bouquets.");
        } else {
            System.out.println("We can make bouquets on day " + numberOfBouquetsBrute);
        }

        int[] nums1 = {1, 10, 3, 10, 2};
        int m1 = 3;
        int k1 = 2;

        int numberOfBouquetsBrute1 = solver.roseGardenBrute(nums1, k1, m1);

        if (numberOfBouquetsBrute1 == -1) {
            System.out.println("We cannot make m bouquets.");
        } else {
            System.out.println("We can make bouquets on day " + numberOfBouquetsBrute1);
        }
    }
}
