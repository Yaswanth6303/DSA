package faqMedium;

import fundamentals.HelperMethods;

import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray_1 {
    public ArrayList<Integer> leadersArrayBrute(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> leadersList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for(int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    leader = false;
                    break;
                }
            }

            if (leader) {
                leadersList.add(nums[i]);
            }
        }

        return leadersList;
    }
    public ArrayList<Integer> leadersArrayOptimal(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> leadersList = new ArrayList<>();
        int max = nums[n - 1];
        leadersList.add(nums[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > max) {
                leadersList.add(nums[i]);
                max = nums[i];
            }
        }

        Collections.reverse(leadersList);

        return leadersList;
    }
    public static void main(String[] args) {
        LeadersInArray_1 leadersInArray = new LeadersInArray_1();
        int[] nums = {1, 2, 5, 3, 1, 2};
        ArrayList<Integer> leadersListBrute = leadersInArray.leadersArrayBrute(nums);
        HelperMethods.printList(leadersListBrute);

        ArrayList<Integer> leadersListOptimal = leadersInArray.leadersArrayOptimal(nums.clone());
        HelperMethods.printList(leadersListOptimal);
    }
}
