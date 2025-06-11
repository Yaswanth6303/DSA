package faqMedium;

import fundamentals.HelperMethods;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class ThreeSum_9 {
    public List<List<Integer>> threeSumBrute(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tripleList = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(tripleList);
                        tripletSet.add(tripleList);
                    }
                }
            }
        }

        return new ArrayList<>(tripletSet);
    }
    public List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> tripletSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> hashSet = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int thirdElement = - (nums[i] + nums[j]);
                if (hashSet.contains(thirdElement)) {
                    List<Integer> tripletList = Arrays.asList(nums[i], nums[j], thirdElement);
                    Collections.sort(tripletList);
                    tripletSet.add(tripletList);
                }
                hashSet.add(nums[j]);
            }
        }

        return new ArrayList<>(tripletSet);
    }
    public List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> tripletList = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    tripletList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return tripletList;
    }
    public static void main(String[] args) {
        ThreeSum_9 threeSum9 = new ThreeSum_9();
        int[] nums = {2, -2, 0, 3, -3, 5};
        System.out.println("Three Sum Brute: ");
        List<List<Integer>> threeSumBrute = threeSum9.threeSumBrute(nums);
        HelperMethods.printListOfLists(threeSumBrute);

        System.out.println("Three Sum Better: ");
        List<List<Integer>> threeSumBetter = threeSum9.threeSumBetter(nums.clone());
        HelperMethods.printListOfLists(threeSumBetter);

        System.out.println("Three Sum Optimal: ");
        List<List<Integer>> threeSumOptimal = threeSum9.threeSumOptimal(nums.clone());
        HelperMethods.printListOfLists(threeSumOptimal);
    }
}
