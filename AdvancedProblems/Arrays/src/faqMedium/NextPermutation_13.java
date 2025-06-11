package faqMedium;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextPermutation_13 {

    public void findNextPermutationBrute(int[] nums) {
        List<List<Integer>> allPermutations = generateAllPermutations(nums);
        int length = nums.length;

        int currentIndex = -1;

        // Find the current permutation index in the sorted list
        for (int i = 0; i < allPermutations.size(); i++) {
            if (isMatchingPermutation(nums, allPermutations.get(i))) {
                currentIndex = i;
                break;
            }
        }

        // Get the next permutation (wrap around if it's the last one)
        int nextIndex = (currentIndex == allPermutations.size() - 1) ? 0 : currentIndex + 1;

        for (int i = 0; i < length; i++) {
            nums[i] = allPermutations.get(nextIndex).get(i);
        }
    }

    private List<List<Integer>> generateAllPermutations(int[] nums) {
        List<List<Integer>> allPermutations = new ArrayList<>();
        backtrackPermutations(0, nums, allPermutations);

        // Sort the permutations lexicographically
        Collections.sort(allPermutations, (perm1, perm2) -> {
            for (int i = 0; i < perm1.size(); i++) {
                if (!perm1.get(i).equals(perm2.get(i))) {
                    return perm1.get(i) - perm2.get(i);
                }
            }
            return 0;
        });

        return allPermutations;
    }

    private void backtrackPermutations(int startIndex, int[] nums, List<List<Integer>> result) {
        if (startIndex == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            swap(nums, startIndex, i);
            backtrackPermutations(startIndex + 1, nums, result);
            swap(nums, startIndex, i); // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean isMatchingPermutation(int[] original, List<Integer> perm) {
        for (int i = 0; i < original.length; i++) {
            if (original[i] != perm.get(i)) return false;
        }
        return true;
    }
    public void findNextPermutationOptimal(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if(pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        for (int i = n - 1; i > pivot; i--) {
            if (nums[i] > pivot) {
                swap(nums, i, pivot);
                break;
            }
        }

        reverse(nums, pivot + 1, n - 1);
        return;
    }
    private void reverse(int[] nums, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            swap(nums, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }
    public static void main(String[] args) {
        NextPermutation_13 solver = new NextPermutation_13();

        int[] nums = {3, 1, 2};
        solver.findNextPermutationBrute(nums);
        System.out.print("Next Permutation Brute: ");
        HelperMethods.printArray(nums);

        solver.findNextPermutationOptimal(nums.clone());
        System.out.print("Next Permutation Optimal: ");
        HelperMethods.printArray(nums);
    }
}
