package faqMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum2_2 {
    /**
     * Time Complexity: O(2^n * n)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] candidates, int sum, List<Integer> current, List<List<Integer>> result) {
        if (sum == 0) {
            result.add(new ArrayList<>(current)); // Found a valid combination
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates at the same level
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > sum) break; // No point in continuing

            current.add(candidates[i]);
            backtrack(i + 1, candidates, sum - candidates[i], current, result); // move to next index
            current.remove(current.size() - 1); // backtrack
        }
    }
    public void backtrack1(int index, int[] candidates, int sum, List<Integer> currentList, List<List<Integer>> result) {
        if(sum == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if(sum < 0 || index == candidates.length) {
            return;
        }

        currentList.add(candidates[index]);
        backtrack(index + 1, candidates, sum - candidates[index], currentList, result);
        currentList.remove(currentList.size() - 1);

        for(int i = index + 1; i < candidates.length; i++) {
            if(candidates[i] != candidates[index]) {
                backtrack(i, candidates, sum, currentList, result);
                break;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2_2 solver = new CombinationSum2_2();

        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;

        List<List<Integer>> combinations = solver.combinationSum2(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
