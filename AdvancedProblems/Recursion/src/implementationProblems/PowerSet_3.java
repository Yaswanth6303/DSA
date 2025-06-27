package implementationProblems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet_3 {
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(n * 2^n)
     */
    public List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, n, nums, currentList, result);
        return result;
    }

    public void backtrack(int index, int n, int[] nums, List<Integer> currentList, List<List<Integer>> result) {
        if (index == n) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // Include the current number
        currentList.add(nums[index]);
        backtrack(index + 1, n, nums, currentList, result);

        // Exclude the current number
        currentList.remove(currentList.size() - 1);
        backtrack(index + 1, n, nums, currentList, result);
    }

    public static void main(String[] args) {
        PowerSet_3 solution = new PowerSet_3();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.powerSet(nums);

        System.out.println("All Subsequences: ");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
