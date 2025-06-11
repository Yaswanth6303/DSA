package faqHard;

import fundamentals.HelperMethods;

import java.util.Map;

public class RepeatingAndMissingNumber_3 {
    public int[] findMissingRepeatingNumbersBrute(int[] nums) {
        int n = nums.length;
        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }

            if (count == 2) repeatingNumber = i;
            if (count == 0) missingNumber = i;
        }

        return new int[]{repeatingNumber, missingNumber};
    }
    public int[] findMissingRepeatingNumbersBetter(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        int repeatingNumber = -1;
        int missingNumber = -1;

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) {
                repeatingNumber = i;
            } else if (hash[i] == 0) {
                missingNumber = i;
            }

            if (repeatingNumber == -1 && missingNumber == -1) {
                break;
            }
        }

        return new int[]{repeatingNumber, missingNumber};
    }
    public int[] findMissingRepeatingNumbersOptimal(int[] nums) {
        int n = nums.length;

        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSquareSum = (long) n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSquareSum = 0;

        for (int num : nums) {
            actualSum += num;
            actualSquareSum += (long) num * (long) num;
        }

        long diffSum = actualSum - expectedSum; // x - y
        long diffSquareSum = actualSquareSum - expectedSquareSum; // x^2 - y^2

        long sumXY = diffSquareSum / diffSum;

        long repeating = (diffSum + sumXY) / 2;
        long missing = repeating - diffSum;

        return new int[] { (int) repeating, (int) missing };
    }
    public static void main(String[] args) {
        RepeatingAndMissingNumber_3 solver = new RepeatingAndMissingNumber_3();
        int[] nums = {3, 5, 4, 1, 1};
        int[] repeatingMissingNumber = solver.findMissingRepeatingNumbersBetter(nums);
        System.out.print("Repeating and Missing number in the array is: ");
        HelperMethods.printArray(repeatingMissingNumber);
    }
}
