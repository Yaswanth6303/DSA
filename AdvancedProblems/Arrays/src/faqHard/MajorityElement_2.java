package faqHard;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_2 {
    public List<Integer> majorityElementTwoBrute(int[] nums) {
        int n = nums.length;
        List<Integer> majorityElementList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (majorityElementList.size() == 0 || majorityElementList.get(0) != nums[i]) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] == nums[i]) {
                        count++;
                    }
                }

                if (count > Math.floor(n / 3)) {
                    majorityElementList.add(nums[i]);
                }

                if (majorityElementList.size() == 2) {
                    break;
                }
            }
        }

        return majorityElementList;
    }
    public List<Integer> majorityElementTwoBetter(int[] nums) {
        int n = nums.length;
        List<Integer> majorityElementList = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();

        int minimum = (n / 3) + 1;

        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

            if (mpp.get(nums[i]) == minimum) {
                majorityElementList.add(nums[i]);
            }

            if (majorityElementList.size() == 2) {
                break;
            }
        }

        return majorityElementList;
    }
    public List<Integer> majorityElementTwoOptimal(int[] nums) {
        int n = nums.length;
        List<Integer> majorityElementList = new ArrayList<>();
        int counter_1 = 0;
        int element_1 = -1;
        int counter_2 = 0;
        int element_2 = -1;

        for (int i = 0; i < n; i++) {
            if (counter_1 == 0 && nums[i] != element_2) {
                counter_1 = 1;
                element_1 = nums[i];
            } else if (counter_2 == 0 && nums[i] != element_1) {
                counter_2 = 1;
                element_2 = nums[i];
            } else if (element_1 == nums[i]) {
                counter_1++;
            } else if (element_2 == nums[i]) {
                counter_2++;
            } else {
                counter_1--;
                counter_2--;
            }
        }

        counter_1 = 0;
        counter_2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == element_1) {
                counter_1++;
            }
            if (nums[i] == element_2) {
                counter_2++;
            }
        }

        int minimum = (n / 3) + 1;
        if (counter_1 >= minimum) {
            majorityElementList.add(element_1);
        }
        if (counter_2 >= minimum && element_1 != element_2) {
            majorityElementList.add(element_2);
        }

        return majorityElementList;
    }
    public static void main(String[] args) {
        MajorityElement_2 majorityElement2 = new MajorityElement_2();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.print("Majority Element Brute: ");
        List<Integer> majorityElementsBrute = majorityElement2.majorityElementTwoBrute(nums);
        HelperMethods.printList(majorityElementsBrute);

        System.out.print("Majority Element Better: ");
        List<Integer> majorityElementsBetter = majorityElement2.majorityElementTwoBetter(nums.clone());
        HelperMethods.printList(majorityElementsBetter);

        System.out.print("Majority Element Optimal: ");
        List<Integer> majorityElementsOptimal = majorityElement2.majorityElementTwoOptimal(nums.clone());
        HelperMethods.printList(majorityElementsOptimal);
    }
}
