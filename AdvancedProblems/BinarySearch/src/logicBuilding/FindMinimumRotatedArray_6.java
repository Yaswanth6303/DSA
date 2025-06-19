package logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMinimumRotatedArray_6 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findMinLinearSearch(ArrayList<Integer> nums) {
        int n = nums.size();
        int minimumValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (minimumValue > nums.get(i)) {
                minimumValue = nums.get(i);
            }
        }

        return minimumValue;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findMinBinarySearch(ArrayList<Integer> nums) {
        int n = nums.size();

        int low = 0;
        int high = n - 1;
        int minimumValue = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums.get(low) <= nums.get(high)) {
                minimumValue = Math.min(minimumValue, nums.get(minimumValue));
                break;
            }

            if (nums.get(low) <= nums.get(mid)) {
                minimumValue = Math.min(minimumValue, nums.get(low));
                low = mid + 1;
            } else {
                minimumValue = Math.min(minimumValue, nums.get(mid));
                high = mid - 1;
            }
        }

        return minimumValue;
    }
    public static void main(String[] args) {
        FindMinimumRotatedArray_6 solver = new FindMinimumRotatedArray_6();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));

        int minimumValueBrute = solver.findMinLinearSearch(arrayList);
        System.out.print("Minimum value (Linear Search): ");
        System.out.println(minimumValueBrute);

        int minimumValueOptimal = solver.findMinBinarySearch(arrayList);
        System.out.print("Minimum value (Binary Search): ");
        System.out.println(minimumValueOptimal);
    }
}

/**
 * Try for different examples
 * 1) 7, 8, 1, 2, 3, 4, 5, 6
 * 2) 4, 5, 1, 2, 3
 * 3) 1, 2
 * 4) 4, 5, 6, 0, 1, 2
 */
