package faqMedium;

import java.util.*;

public class Subset1_4 {
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     */
    public List<List<Integer>> generateAllSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            generateSubsets(i + 1, nums, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subset1_4 generator = new Subset1_4();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generator.generateAllSubsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
