package implementationProblems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet_3 {

    /**
     * RECURSIVE SOLUTION (Backtracking)
     * Time Complexity: O(2^n)
     * Space Complexity: O(n * 2^n)
     */
    public List<List<Integer>> powerSetRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(0, nums, currentList, result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> currentList, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Include the current element
        currentList.add(nums[index]);
        backtrack(index + 1, nums, currentList, result);

        // Exclude the current element
        currentList.remove(currentList.size() - 1);
        backtrack(index + 1, nums, currentList, result);
    }

    /**
     * ITERATIVE SOLUTION
     * Time Complexity: O(2^n)
     * Space Complexity: O(n * 2^n)
     */
    public List<List<Integer>> powerSetIterative(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // Start with empty subset

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(result.get(i));
                newSubset.add(num);
                result.add(newSubset);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PowerSet_3 solution = new PowerSet_3();
        int[] nums = {1, 2, 3};

        // Recursive Solution
        System.out.println("Recursive Power Set:");
        List<List<Integer>> recursiveResult = solution.powerSetRecursive(nums);
        for (List<Integer> subset : recursiveResult) {
            System.out.println(subset);
        }

        System.out.println("\nIterative Power Set:");
        // Iterative Solution
        List<List<Integer>> iterativeResult = solution.powerSetIterative(nums);
        for (List<Integer> subset : iterativeResult) {
            System.out.println(subset);
        }
    }
}
