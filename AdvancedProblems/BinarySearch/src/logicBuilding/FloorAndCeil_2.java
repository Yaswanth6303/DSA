package logicBuilding;

public class FloorAndCeil_2 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] getFloorAndCeilBrute_1(int[] nums, int x) {
        int n = nums.length;

        int floorValue = -1;
        int ceilValue = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= x && (ceilValue == -1 || nums[i] < ceilValue)) ceilValue = nums[i];
            if (nums[i] <= x && nums[i] > floorValue) floorValue = nums[i];
        }

        return new int[]{floorValue, ceilValue};
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] getFloorAndCeilBrute_2(int[] nums, int x) {
        int n = nums.length;

        int floorValue = -1;
        int ceilValue = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= x && nums[i] > floorValue) {
                floorValue = nums[i];
            }

            if (nums[i] >= x) {
                ceilValue = nums[i];
                break;
            }
        }

        return new int[]{floorValue, ceilValue};
    }
    public int findFloor(int[] nums, int low, int high, int x) {
        int floor = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return floor;
    }
    public int findCeil(int[] nums, int low, int high, int x) {
        int ceil = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ceil;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int[] getFloorAndCeilOptimal(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        int getFloor = findFloor(nums, low, high, x);
        int getCeil = findCeil(nums, low, high, x);

        return new int[]{getFloor, getCeil};
    }
    public static void main(String[] args) {
        FloorAndCeil_2 floorAndCeil2 = new FloorAndCeil_2();
        int[] nums = {10, 20, 30, 40, 50};
        int target = 25;

        int[] getFloorCeilBrute_1 = floorAndCeil2.getFloorAndCeilBrute_1(nums, target);
        System.out.print("Floor and Ceil Values in the array is(Brute_1): ");
        HelperMethods.printArray(getFloorCeilBrute_1);

        int[] getFloorCeilBrute_2 = floorAndCeil2.getFloorAndCeilBrute_2(nums, target);
        System.out.print("Floor and Ceil Values in the array is(Brute_2): ");
        HelperMethods.printArray(getFloorCeilBrute_2);

        int[] getFloorCeilOptimal = floorAndCeil2.getFloorAndCeilOptimal(nums.clone(), target);
        System.out.print("Floor and Ceil Values in the array is(Optimal): ");
        HelperMethods.printArray(getFloorCeilOptimal);
    }
}
