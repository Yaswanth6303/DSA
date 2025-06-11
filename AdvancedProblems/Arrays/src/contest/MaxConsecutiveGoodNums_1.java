package contest;

import java.util.HashSet;
import java.util.Set;

public class MaxConsecutiveGoodNums_1 {
    /**
     * Brute Force approach to find the maximum number of consecutive good numbers.
     * For every starting index, it checks forward until a bad number is found.
     *
     * Time Complexity: O(n^2 * m)
     * Space Complexity: O(1)
     */
    public int maxConsecutiveGoodNumsBrute(int[] nums, int[] goodNumbers) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentLen = 0;
            for (int j = i; j < nums.length; j++) {
                boolean isGood = false;
                for (int good : goodNumbers) {
                    if (nums[j] == good) {
                        isGood = true;
                        break;
                    }
                }
                if (!isGood) break;
                currentLen++;
            }
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }

    /**
     * Better approach using a linear scan. For each number in nums,
     * it checks if it exists in the goodNumbers array.
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    public int maxConsecutiveGoodNumsBetter(int[] nums, int[] goodNumbers) {
        int n = nums.length;
        int m = goodNumbers.length;

        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            boolean isGood = false;
            for (int j = 0; j < m; j++) {
                if (nums[i] == goodNumbers[j]) {
                    isGood = true;
                    break;
                }
            }

            if (isGood) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    /**
     * Optimal approach using a HashSet to store good numbers for O(1) lookup.
     * It scans nums once and tracks the maximum streak of consecutive good numbers.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(m)
     */
    public int maxConsecutiveGoodNumbersOptimal(int[] nums, int[] goodNumbers) {
        int count = 0;
        int maxCount = 0;

        Set<Integer> goodSet = new HashSet<>();
        for (int num : goodNumbers) {
            goodSet.add(num);
        }

        for (int num : nums) {
            if (goodSet.contains(num)) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }

    /**
     * Main method to test all three approaches.
     */
    public static void main(String[] args) {
        MaxConsecutiveGoodNums_1 solver = new MaxConsecutiveGoodNums_1();

        int[] nums = {3, 5, 3, 5, 3};
        int[] goodNumbers = {3, 5};

        int bruteResult = solver.maxConsecutiveGoodNumsBrute(nums, goodNumbers);
        int betterResult = solver.maxConsecutiveGoodNumsBetter(nums, goodNumbers);
        int optimalResult = solver.maxConsecutiveGoodNumbersOptimal(nums, goodNumbers);

        System.out.println("Brute Force Result: " + bruteResult);
        System.out.println("Better Approach Result: " + betterResult);
        System.out.println("Optimal Approach Result: " + optimalResult);
    }
}
