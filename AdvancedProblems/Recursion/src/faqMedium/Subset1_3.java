package faqMedium;

import java.util.*;

public class Subset1_3 {
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: The recursion stack space will take O(n). Note that if you consider
     * the space used to return the output that the space complexity can go up to O(2n).
     */
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        backtrack(0, 0, nums, result);
        return result;
    }

    private void backtrack(int index, int currentSum, int[] nums, List<Integer> result) {
        if (index == nums.length) {
            result.add(currentSum);
            return;
        }

        // Include current element
        backtrack(index + 1, currentSum + nums[index], nums, result);

        // Exclude current element
        backtrack(index + 1, currentSum, nums, result);
    }

    public static void main(String[] args) {
        Subset1_3 sol = new Subset1_3();
        int[] nums = {1, 2, 3};

        List<Integer> sums = sol.subsetSums(nums);
        Collections.sort(sums); // Optional: to print in ascending order

        System.out.println("Subset sums:");
        for (int sum : sums) {
            System.out.print(sum + " ");
        }
    }
}

