package faqMedium;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.List;

public class ReArrangeElementsBySign_2 {
    public int[] rearrangeElementsBrute(int[] nums) {
        int n = nums.length;
        List<Integer> posElements = new ArrayList<>();
        List<Integer> negElements = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                posElements.add(num);
            } else {
                negElements.add(num);
            }
        }

//        int posIndex = 0, negIndex = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (i % 2 == 0 && posIndex < posElements.size()) {
//                nums[i] = posElements.get(posIndex++);
//            } else if (negIndex < negElements.size()) {
//                nums[i] = negElements.get(negIndex++);
//            }
//        }

        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = posElements.get(i);
            nums[2 * i + 1] = negElements.get(i);
        }

        return nums;
    }
    public int[] rearrangeElementsOptimal(int[] nums) {
        int n = nums.length;
        int[] rearrangeArray = new int[n];
        int posIndex = 0;
        int negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                rearrangeArray[posIndex] = nums[i];
                posIndex += 2;
            } else {
                rearrangeArray[negIndex] = nums[i];
                negIndex += 2;
            }
        }

        return rearrangeArray;
    }
    public static void main(String[] args) {
        ReArrangeElementsBySign_2 reArrangeElementsBySign = new ReArrangeElementsBySign_2();
        int[] nums = {1, 2, -4, -5};
        int[] rearrangeArrayBrute = reArrangeElementsBySign.rearrangeElementsBrute(nums);
        System.out.print("Rearrange Elements Brute: ");
        HelperMethods.printArray(rearrangeArrayBrute);

        int[] rearrangeArrayOptimal = reArrangeElementsBySign.rearrangeElementsOptimal(nums);
        System.out.print("Rearrange Elements Optimal: ");
        HelperMethods.printArray(rearrangeArrayOptimal);
    }
}
