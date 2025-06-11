package fundamentals;

import java.util.ArrayList;
import java.util.List;

public class MajorityConsecutiveOnes2_7 {
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
        int[] nums = {1, 0, 1, 1, 0};
        MajorityConsecutiveOnes2_7 solver = new MajorityConsecutiveOnes2_7();
        System.out.print("Max Consecutive Ones Brute: ");
        int maxConsecutiveOnesBrute = solver.findMaxConsecutiveOnesBrute(nums);
        System.out.println(maxConsecutiveOnesBrute);

        System.out.print("Max Consecutive Ones Optimal: ");
        int maxConsecutiveOnesOptimal = solver.findMaxConsecutiveOnesOptimal(nums.clone());
        System.out.println(maxConsecutiveOnesOptimal);
    }
}
