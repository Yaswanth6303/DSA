package faqMedium;

import fundamentals.HelperMethods;

import java.util.*;

public class FourSum_10 {
    public List<List<Integer>> fourSumBrute(int[] nums, int target) {
        Set<List<Integer>> qudrapleSet = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            qudrapleSet.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        }
                    }
                }
            }
        }

        return new ArrayList<>(qudrapleSet);
    }
    public List<List<Integer>> fourSumBetter(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> qudrapleSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j] + nums[k];
                    long moreNeeded = target - sum;

                    if (hashset.contains(moreNeeded)) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], (int) moreNeeded);
                        Collections.sort(quad);
                        qudrapleSet.add(quad);
                    }
                    hashset.add((long) nums[k]);
                }
            }
        }

        return new ArrayList<>(qudrapleSet);
    }
    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> qudrapleList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                int k = j + 1;
                int l = n - 1;
                
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        qudrapleList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        while (k < n && nums[k] == nums[k - 1]) k++;
                        while (l < n && nums[l] == nums[l + 1]) l--;
                    }
                }
            }
        }

        return qudrapleList;
    }
    public static void main(String[] args) {
        FourSum_10 solver = new FourSum_10();
        int[] nums = { 1, -2, 3, 5, 7, 9 };
        int target = 7;

        System.out.println("Quadruple List (Brute Force):");
        List<List<Integer>> brute = solver.fourSumBrute(nums, target);
        HelperMethods.printListOfLists(brute);

        System.out.println("Quadruple List (Better Approach):");
        List<List<Integer>> better = solver.fourSumBetter(nums.clone(), target);
        HelperMethods.printListOfLists(better);

        System.out.println("Quadruple List (Optimal Approach):");
        List<List<Integer>> optimal = solver.fourSumOptimal(nums.clone(), target);
        HelperMethods.printListOfLists(optimal);
    }
}
