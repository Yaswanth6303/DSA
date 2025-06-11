package faqHard;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_1 {
    public int majorityElementBrute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }
    public int majorityElementBetter(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: mpp.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > n / 2) {
                return key;
            }
        }

        return -1;
    }
    public int majorityElementOptimal(int[] nums) {
        int n = nums.length;
        int count = 0;
        int element = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                element = nums[i];
            } else if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }

        int countElement = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element) {
                countElement++;
            }
        }

        if (countElement > n / 2) {
            return element;
        }

        return -1;
    }
    public static void main(String[] args) {
        MajorityElement_1 majorityElementI = new MajorityElement_1();
        int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};

        System.out.print("Majority Element Brute: ");
        int majorityElementBrute = majorityElementI.majorityElementBrute(nums);
        System.out.println(majorityElementBrute);

        System.out.print("Majority Element Better: ");
        int majorityElementBetter = majorityElementI.majorityElementBetter(nums.clone());
        System.out.println(majorityElementBetter);

        System.out.print("Majority Element Optimal: ");
        int majorityElementOptimal = majorityElementI.majorityElementOptimal(nums.clone());
        System.out.println(majorityElementOptimal);
    }
}
