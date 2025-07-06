package faqMedium;

import java.util.List;
import java.util.ArrayList;

public class CombinationSum1_1 {
    /**
     * Time Complexity: The time complexity is O(N^(T/M + 1)), where N is the number of candidates,
     * T is the target, and M is the minimum value in candidates.
     * Space Complexity: The space complexity is O(T/M), where T is the target and M is the minimum
     * value in candidates, due to the depth of the recursion.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int index, int[] candidates, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }
        if (index == candidates.length || target < 0) {
            return; // No valid combination
        }

        // Include the current element
        current.add(candidates[index]);
        backtrack(index, candidates, target - candidates[index], current, result); // same index because we can reuse
        current.remove(current.size() - 1); // backtrack

        // Exclude the current element and move to next
        backtrack(index + 1, candidates, target, current, result);
    }
    public static void main(String[] args) {
        CombinationSum1_1 solution = new CombinationSum1_1();
        int[] candidates = {1, 3, 2};
        int target = 3;
        solution.combinationSum(candidates, target);
        List<List<Integer>> recursiveResult = solution.combinationSum(candidates, target);
        for (List<Integer> sequence : recursiveResult) {
            System.out.println(sequence);
        }
    }
}
