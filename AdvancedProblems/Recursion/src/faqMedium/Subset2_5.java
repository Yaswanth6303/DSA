package faqMedium;

import java.util.*;

public class Subset2_5  {
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(2^n)
     */
    public List<List<Integer>> generateUniqueSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubsets(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {
        result.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            currentSubset.add(nums[i]);
            generateSubsets(i + 1, nums, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    private void generateSubsets1(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.add(nums[index]);
        generateSubsets1(index + 1, nums, currentSubset, result);
        currentSubset.remove(currentSubset.size() - 1);

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                generateSubsets1(i, nums, currentSubset, result);
                return;
            }
        }

        generateSubsets1(nums.length, nums, currentSubset, result);
    }

    public static void main(String[] args) {
        Subset2_5 generator = new Subset2_5();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsets = generator.generateUniqueSubsets(nums);

        System.out.println("All unique subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
