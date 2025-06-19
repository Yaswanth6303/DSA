package logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;

public class FindRotations_7 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findKRotationBrute_1(ArrayList<Integer> nums) {
        int n = nums.size();

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return i + 1;
            }
        }

        return 0;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findKRotationBrute_2(ArrayList<Integer> nums) {
        int n = nums.size();
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) < nums.get(i + 1)) {
                count++;
            } else {
                break;
            }
        }

        if (count == n - 1) {
            return 0;
        }

        return count + 1;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findKRotationOptimal(ArrayList<Integer> nums) {
        int n = nums.size();

        int low = 0;
        int high = n - 1;
        int minimumValue = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < minimumValue) {
                    minimumValue = nums.get(low);
                    index = low;
                }
                break;
            }

            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < minimumValue) {
                    minimumValue = nums.get(low);
                    index = low;
                }
                low = mid + 1;
            } else {
                if (nums.get(mid) < minimumValue) {
                    minimumValue = nums.get(mid);
                    index = mid;
                }
                high = mid - 1;
            }
        }

        return index;
    }
    public static void main(String[] args) {
        FindRotations_7 solver = new FindRotations_7();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));

        System.out.print("Rotated Brute: ");
        int findKRotationsBrute = solver.findKRotationBrute_1(arrayList);
        System.out.println(findKRotationsBrute);

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2));
        System.out.print("Rotated Optimal: ");
        int findKRotationsOptimal = solver.findKRotationOptimal(arrayList1);
        System.out.println(findKRotationsOptimal);
    }
}
