package contest;

import java.util.ArrayList;
import java.util.List;

public class NumberOfJumps_3 {
    public int totalJumpsBrute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int threshold = nums[i] + k;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < threshold) {
                    count++;
                }
            }
        }

        return count;
    }
    public int totalJumpsBetter(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        List<Integer> seen = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            int threshold = nums[i] + k;
            int idx = lowerBound(seen, threshold);
            count += idx;
            insertSorted(seen, nums[i]);
        }

        return count;
    }

    // Binary search for lower bound
    private int lowerBound(List<Integer> list, int target) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Insert while keeping the list sorted
    private void insertSorted(List<Integer> list, int value) {
        int pos = lowerBound(list, value);
        list.add(pos, value);
    }
    public static void main(String[] args) {
        NumberOfJumps_3 solution = new NumberOfJumps_3();

        int[] nums1 = {3, 1, 10, 6, 5};
        int k1 = 2;
        System.out.println("Brute Output 1: " + solution.totalJumpsBrute(nums1, k1));

        int[] nums2 = {1, 4, 5, 1, 7};
        int k2 = 3;
        System.out.println("Brute Output 2: " + solution.totalJumpsBrute(nums2, k2));

        int[] nums3 = {3, 1, 10, 6, 5};
        int k3 = 2;
        System.out.println("Better Output 1: " + solution.totalJumpsBetter(nums3, k3));

        int[] nums4 = {1, 4, 5, 1, 7};
        int k4 = 3;
        System.out.println("Better Output 2: " + solution.totalJumpsBetter(nums4, k4));
    }
}
