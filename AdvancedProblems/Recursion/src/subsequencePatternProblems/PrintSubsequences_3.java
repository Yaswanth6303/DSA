package subsequencePatternProblems;

import java.util.List;
import java.util.ArrayList;

public class PrintSubsequences_3 {
    /**
     * Time Complexity: O(2^n * n)
     * Space Complexity: O(n * 2^n) (for storing results)
     * Auxiliary Stack Space: O(n) (due to recursion)
     */
    public boolean checkSubsequenceSum(int[] nums, int k) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        solve(0, k, nums, currentList, result);

        if (!result.isEmpty()) {
            System.out.println("All subsequences that sum to " + k + ":");
            for (List<Integer> list : result) {
                System.out.println(list);
            }
            return true;
        }

        return false;
    }

    public void solve(int index, int sum, int[] nums, List<Integer> currentList, List<List<Integer>> result) {
        if (sum < 0) return;
        if (index == nums.length) {
            if (sum == 0) {
                result.add(new ArrayList<>(currentList)); // Add valid subsequence
            }
            return;
        }

        // Include nums[index]
        currentList.add(nums[index]);
        solve(index + 1, sum - nums[index], nums, currentList, result);
        currentList.remove(currentList.size() - 1); // Backtrack

        // Exclude nums[index]
        solve(index + 1, sum, nums, currentList, result);
    }

    public static void main(String[] args) {
        PrintSubsequences_3 sol = new PrintSubsequences_3();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 8;
        boolean found = sol.checkSubsequenceSum(nums, target);
        System.out.println("Result: " + found); // Expected output: true + all subsequences
    }
}
