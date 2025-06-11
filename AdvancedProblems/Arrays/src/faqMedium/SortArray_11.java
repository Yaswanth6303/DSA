package faqMedium;

import fundamentals.HelperMethods;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SortArray_11 {
    public void sortZeroOneTwoBrute(int[] nums) {
        Arrays.sort(nums); // Time complexity: O(n log n)
    }

    public void sortZeroOneTwoBetter(int[] nums) {

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        // Check if any number is outside the allowed range (0, 1, 2)
        for (int num : hashSet) {
            if (num < 0 || num > 2) {
                System.out.println("Array must contain only 0s, 1s, and 2s.");
                return;
            }
        }

        int n = nums.length;
        int count_0 = 0, count_1 = 0, count_2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) count_0++;
            else if (nums[i] == 1) count_1++;
            else count_2++;
        }

        for (int i = 0; i < count_0; i++) nums[i] = 0;
        for (int i = count_0; i < count_0 + count_1; i++) nums[i] = 1;
        for (int i = count_0 + count_1; i < n; i++) nums[i] = 2;
    }
    public void sortZeroOneTwoOptimal(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        SortArray_11 sortArray11 = new SortArray_11();
        int[] nums = {1, 0, 2, 1, 0, 2, 0, 0};

        System.out.print("Sort Array Brute: ");
        int[] bruteArray = nums.clone();
        sortArray11.sortZeroOneTwoBrute(bruteArray);
        HelperMethods.printArray(bruteArray);

        System.out.print("Sort Array Better: ");
        int[] betterArray = nums.clone();
        sortArray11.sortZeroOneTwoBetter(betterArray);
        HelperMethods.printArray(betterArray);

        System.out.print("Sorted Array Optimal: ");
        sortArray11.sortZeroOneTwoOptimal(nums);
        HelperMethods.printArray(nums);
    }
}
