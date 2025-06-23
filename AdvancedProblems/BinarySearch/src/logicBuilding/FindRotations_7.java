package logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;

public class FindRotations_7 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findKRotationBruteMethod1(ArrayList<Integer> nums) {
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
    public int findKRotationBruteMethod2(ArrayList<Integer> nums) {
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
    public int findKRotationOptimalMethod1(ArrayList<Integer> nums) {
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
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findKRotationOptimalMethod2(ArrayList<Integer> nums) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;

        if (nums.get(low) <= nums.get(high)) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && nums.get(mid) < nums.get(mid - 1)) {
                return mid;
            }

            if (mid < n - 1 && nums.get(mid) > nums.get(mid + 1)) {
                return mid + 1;
            }

            if (nums.get(low) <= nums.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        FindRotations_7 solver = new FindRotations_7();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));

        System.out.print("Rotated Brute M1: ");
        int findKRotationsBruteM1 = solver.findKRotationBruteMethod1(arrayList);
        System.out.println(findKRotationsBruteM1);

        System.out.print("Rotated Brute M2: ");
        int findKRotationsBruteM2 = solver.findKRotationBruteMethod2(arrayList);
        System.out.println(findKRotationsBruteM2);

        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2));
        System.out.print("Rotated Optimal: ");
        int findKRotationsOptimalM1 = solver.findKRotationOptimalMethod1(arrayList1);
        System.out.println(findKRotationsOptimalM1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2));
        System.out.print("Rotated Optimal: ");
        int findKRotationsOptimalM2 = solver.findKRotationOptimalMethod2(arrayList2);
        System.out.println(findKRotationsOptimalM2);
    }
}
