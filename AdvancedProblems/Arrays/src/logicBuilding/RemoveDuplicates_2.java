package logicBuilding;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates_2 {
    /**
     * Time Complexity -> O(n * log n) + O(n)
     * Space Complexity -> O(n)
     */
    public int removeDuplicatesBrute(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int value : nums) {
            set.add(value);
        }

        int k = set.size();

        int j = 0;
        for(int value : set) {
            nums[j++] = value;
        }

        return k;
    }
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public int removeDuplicatesOptimal(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
    public static void main(String[] args) {
        RemoveDuplicates_2 removeDuplicates2 = new RemoveDuplicates_2();
        int[] nums = {1, 1, 2, 2, 3, 3};

        int uniqueElementsBrute = removeDuplicates2.removeDuplicatesBrute(nums);
        System.out.print("Unique Elements Brute: ");
        System.out.println(uniqueElementsBrute);

        int[] numsClone = {1, 1, 2, 2, 3, 3};
        int uniqueElementsOptimal = removeDuplicates2.removeDuplicatesOptimal(numsClone);
        System.out.print("Unique Elements Optimal: ");
        System.out.println(uniqueElementsOptimal);
    }
}
