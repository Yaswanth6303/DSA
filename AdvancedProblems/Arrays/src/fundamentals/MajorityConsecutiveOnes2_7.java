package fundamentals;

import java.util.ArrayList;
import java.util.List;

public class MajorityConsecutiveOnes2_7 {
    /**
     * Time Complexity:
     * -> O(n) to find all 0 indices and store in zeroIndices list
     * -> For each 0 (let's say there are k zeros):
     *      - O(n) to clone the array
     *      - O(n) to compute max consecutive ones after flipping
     * -> So total time = O(n) + k * (O(n) + O(n)) = O(n) + O(k * 2n) = O(n + 2kn) = O(kn)
     *
     * Space Complexity:
     * -> O(k) for storing zeroIndices
     * -> O(n) for cloned array in each iteration (not cumulative since reused)
     * -> So overall auxiliary space = O(k + n)
     */
    public int findMaxConsecutiveOnesBrute(int[] nums) {
        int n = nums.length;
        int maxOnes = 0;

        List<Integer> zeroIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroIndices.add(i);
            }
        }

        if (zeroIndices.isEmpty()) {
            return nums.length;
        }

        for (int index : zeroIndices) {
            int[] modifiedArray = nums.clone();
            modifiedArray[index] = 1;

            int count = 0;
            int maxCount = Integer.MIN_VALUE;

            for (int i = 0; i < modifiedArray.length; i++) {
                if (modifiedArray[i] == 1) {
                    count++;
                    maxCount = Math.max(count, maxCount);
                } else {
                    count = 0;
                }
            }
            maxOnes = Math.max(maxCount, maxOnes);
        }

        return maxOnes;
    }
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public int findMaxConsecutiveOnesOptimal(int[] nums) {
        int maxConsecutiveOnes = 0;
        int zeroCount = 0;
        int j = 0;

        // Iterate through the array with the right pointer
        for (int i = 0; i < nums.length; ++i) {
            // If a zero is encountered, increment the zero count
            if (nums[i] == 0) {
                zeroCount++;
            }

            /* If there are more than 1 zero, move
             the left pointer to shrink the sub-array */
            while (zeroCount > 1) {
                if (nums[j] == 0) {
                    zeroCount--;
                }
                j++;  // Move left pointer to the right
            }

            // Update the maximum length of consecutive 1s
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, i - j + 1);
        }
        return maxConsecutiveOnes;
    }
    public static void main(String[] args) {
        MajorityConsecutiveOnes2_7 solver = new MajorityConsecutiveOnes2_7();
        int[] nums = {1, 0, 1, 1, 0};

        System.out.print("Max Consecutive Ones Brute: ");
        int maxConsecutiveOnesBrute = solver.findMaxConsecutiveOnesBrute(nums);
        System.out.println(maxConsecutiveOnesBrute);

        System.out.print("Max Consecutive Ones Optimal: ");
        int maxConsecutiveOnesOptimal = solver.findMaxConsecutiveOnesOptimal(nums.clone());
        System.out.println(maxConsecutiveOnesOptimal);
    }
}
