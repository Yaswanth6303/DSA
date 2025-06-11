package fundamentals;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch_1 {
    public int linearSearch(int[] nums, int target) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
    public int[] linearSearchAllElements(int[] nums, int target) {
        List<Integer> targetList = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if (nums[i] == target) {
                targetList.add(i);
            }
        }

        int[] targetArray = new int[targetList.size()];
        for (int i = 0; i < targetList.size(); i++) {
            targetArray[i] = targetList.get(i);
        }

        return targetArray;
    }
    public static void main(String[] args) {
        LinearSearch_1 linearSearch1 = new LinearSearch_1();
        int[] nums = {2, 3, 4, 5, 3};
        int target = 3;
        int targetIndex = linearSearch1.linearSearch(nums, target);
        if (targetIndex >= 0) {
            System.out.println("Target index: " + targetIndex);
        } else {
            System.out.println("Target is not available in the array");
        }
        int[] targetArray = linearSearch1.linearSearchAllElements(nums.clone(), target);
        System.out.println("Target value array: ");
        HelperMethods.printArray(targetArray);
    }
}
