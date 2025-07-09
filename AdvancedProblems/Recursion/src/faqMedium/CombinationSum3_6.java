package faqMedium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3_6 {
    /**
     * Time Complexity: The time complexity is O(9!/(9-k)!) in the worst case, which simplifies
     * to O(1) since k is limited to a maximum of 9, so the number of calls to backtrack is
     * bounded.
     * Space Complexity: The space complexity is O(k), due to the depth of the recursion stack
     * and the space used to store the currentList.
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> currentList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, currentList, result);
        return result;
    }
    public void backtrack(int sum, int k, List<Integer> currentList, List<List<Integer>> result) {
        if (sum == 0 && currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (sum < 0 || currentList.size() > k) return;

        int element = currentList.isEmpty() ? 1 : currentList.get(currentList.size() - 1) + 1;

        for (int i = element; i <= 9; i++) {
            if (i <= sum) {
                currentList.add(i);
                backtrack(sum - i, k, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        CombinationSum3_6 solution = new CombinationSum3_6();
        int k = 3; // Number of elements in the combination
        int n = 9; // Target sum
        List<List<Integer>> result = solution.combinationSum3(k, n);

        // Print the result
        for (List<Integer> combination : result) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
