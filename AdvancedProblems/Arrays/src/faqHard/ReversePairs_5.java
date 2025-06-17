package faqHard;

import java.util.ArrayList;
import java.util.List;

public class ReversePairs_5 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int reversePairsBrute(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2 * nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            temp.add(nums[left++]);
        }

        while (right <= high) {
            temp.add(nums[right++]);
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
    private int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2 * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }

        return count;
    }
    private int mergeSort(int[] nums, int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }

        int mid = low + (high - low) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

        return count;
    }
    /**
     * Time Complexity: O(2N * logN)
     * Space Complexity: O(N)
     */
    public int reversePairsOptimal(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }
    public static void main(String[] args) {
        ReversePairs_5 solver = new ReversePairs_5();
        int[] nums = {40, 25, 19, 12, 9, 6, 2};
        System.out.print("Reverse Pairs Brute: ");
        int reversePairsBrute = solver.reversePairsBrute(nums);
        System.out.println(reversePairsBrute);

        System.out.print("Reverse Pairs Optimal: ");
        int reversePairsOptimal = solver.reversePairsOptimal(nums.clone());
        System.out.println(reversePairsOptimal);
    }
}
