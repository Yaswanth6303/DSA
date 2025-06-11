package faqMedium;

import java.util.ArrayList;
import java.util.List;

public class KadaneAlgorithm_12 {
    public int maxSubArrayBrute(int[] nums) {
        int n = nums.length;
        int maximumSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maximumSum = Math.max(sum, maximumSum);
            }
        }
        return maximumSum;
    }
    public int maxSubArrayBetter(int[] nums) {
        int n = nums.length;
        int maximumSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maximumSum = Math.max(sum, maximumSum);
            }
        }

        return maximumSum;
    }
    // Optimal Solution
    public int kadaneAlgorithm_1(int[] nums) {
        int n = nums.length;
        int maximumSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum < 0) {
                sum = 0;
            }
            maximumSum = Math.max(sum, maximumSum);
        }
        // If all numbers are negative, consider empty sub-array (sum = 0)
        if (maximumSum < 0) {
            return 0;
        }
        return maximumSum;
    }
    public int kadaneAlgorithm_2(int[] nums) {
        int n = nums.length;

        // To store the starting and ending indices of the sub-array with maximum sum
        int startIndex = -1;
        int endIndex = -1;

        int sum = 0;  // Current sub-array sum
        int start = 0; // Start index of the current sub-array
        int maximumSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // If the current sum is 0, consider this index as the new starting point of a potential sub-array
            if (sum == 0) start = i;

            sum += nums[i];

            if (sum < 0) {
                sum = 0;

                // Save the last valid start index before resetting
                startIndex = start;

                // Set the current index as the end of the sub-array before reset
                endIndex = i;
            }

            // Update the maximum sum found so far
            maximumSum = Math.max(sum, maximumSum);
        }

        return maximumSum;
    }
    public static void kadaneWithAllMaxSubArrays(int[] nums) {
        int n = nums.length;

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        // List to store pairs of (startIndex, endIndex) of max sum sub-arrays
        List<int[]> maxSubArrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // If current sum is 0, potential new sub-array starts here
            if (currentSum == 0) {
                start = i;
            }

            currentSum += nums[i];

            if (currentSum > maxSum) {
                // Found a new max sum, clear previous ones
                maxSum = currentSum;
                maxSubArrays.clear();
                maxSubArrays.add(new int[]{start, i});
            } else if (currentSum == maxSum) {
                // Found another sub-array with same max sum
                maxSubArrays.add(new int[]{start, i});
            }

            // If sum goes negative, reset
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        // Print all sub-arrays with max sum
        System.out.println("Max Sum (AllMaxSubArrays): " + maxSum);
        System.out.println("Sub-arrays with Maximum Sum:");
        for (int[] pair : maxSubArrays) {
            // Get start and end index current pair (pair contains only start and end index)
            int s = pair[0], e = pair[1];
            System.out.print("[ ");
            for (int i = s; i <= e; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println("]");
        }
    }
    public static void main(String[] args) {
        KadaneAlgorithm_12 kadaneAlgorithm12 = new KadaneAlgorithm_12();
        int[] nums = {1, 2, 3, -2, 5, -3, 1, 2, 3};
        int maxSumBrute = kadaneAlgorithm12.maxSubArrayBrute(nums);
        System.out.println("Max Sub-array Sum Brute: " + maxSumBrute);

        int maxSumBetter = kadaneAlgorithm12.maxSubArrayBetter(nums.clone());
        System.out.println("Max Sub-array Sum Better: " + maxSumBetter);

        int maxSumOptimal1 = kadaneAlgorithm12.kadaneAlgorithm_1(nums.clone());
        System.out.println("Max Sub-array Sum Optimal_1: " + maxSumOptimal1);

        int maxSumOptimal2 = kadaneAlgorithm12.kadaneAlgorithm_2(nums.clone());
        System.out.println("Max Sub-array Sum Optimal_2: " + maxSumOptimal2);

        kadaneAlgorithm12.kadaneWithAllMaxSubArrays(nums.clone());
    }
}
