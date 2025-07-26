package faqHard;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_2 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
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
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<Integer> majorityElementTwoBetter_1(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mpp = new HashMap<>();

        for(int num : nums) {
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > (n / 3)) {
                result.add(key);
            }

            if (result.size() == 2) {
                break;
            }
        }

        return result;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static List<Integer> majorityElementTwoBetter_2(int[] nums) {
        int n = nums.length;

        List<Integer> majorityList = new ArrayList<>();

        Map<Integer, Integer> mpp = new HashMap<>();

        for(int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > n / 3) {
                majorityList.add(key);
            }

            if(majorityList.size() == 2) break;
        }

        return majorityList;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public List<Integer> majorityElementTwoOptimal(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        int counter_1 = 0;
        int element_1 = Integer.MIN_VALUE;
        int counter_2 = 0;
        int element_2 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            if(counter_1 == 0 && nums[i] != element_2) {
                counter_1 = 1;
                element_1 = nums[i];
            } else if(counter_2 == 0 && nums[i] != element_1) {
                counter_2 = 1;
                element_2 = nums[i];
            } else if(nums[i] == element_1) {
                counter_1++;
            } else if(nums[i] == element_2) {
                counter_2++;
            } else {
                counter_1--;
                counter_2--;
            }
        }

        counter_1 = 0;
        counter_2 = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] == element_1) {
                counter_1++;
            }

            if(nums[i] == element_2) {
                counter_2++;
            }
        }

        if(counter_1 > (n / 3)) result.add(element_1);
        if(counter_2 > (n / 3) && element_1 != element_2) result.add(element_2);

        return result;
    }
    public static void main(String[] args) {
        MajorityElement_2 majorityElement2 = new MajorityElement_2();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.print("Majority Element Brute: ");
        List<Integer> majorityElementsBrute = majorityElement2.majorityElementTwoBrute(nums);
        HelperMethods.printList(majorityElementsBrute);

        System.out.print("Majority Element Better_1: ");
        List<Integer> majorityElementsBetter_1 = majorityElement2.majorityElementTwoBetter_1(nums.clone());
        HelperMethods.printList(majorityElementsBetter_1);

        System.out.print("Majority Element Better_2: ");
        List<Integer> majorityElementsBetter_2 = majorityElement2.majorityElementTwoBetter_2(nums.clone());
        HelperMethods.printList(majorityElementsBetter_2);

        System.out.print("Majority Element Optimal: ");
        List<Integer> majorityElementsOptimal = majorityElement2.majorityElementTwoOptimal(nums.clone());
        HelperMethods.printList(majorityElementsOptimal);
    }
}
