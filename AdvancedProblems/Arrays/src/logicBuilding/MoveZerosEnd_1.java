package logicBuilding;

import fundamentals.HelperMethods;

public class MoveZerosEnd_1 {
    /**
     * Time Complexity -> O(2n)
     * Space Complexity -> O(n)
     */
    public void moveZerosBrute(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[count++] = nums[i];
            }
        }

        for (int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }

        for (int i = count; i < n; i++) {
            nums[i] = 0;
        }
    }
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public void moveZerosOptimal(int[] nums) {
        int n = nums.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        while (j < n) {
            nums[j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {
        MoveZerosEnd_1 moveZerosEnd1 = new MoveZerosEnd_1();
        int[] nums = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};

        moveZerosEnd1.moveZerosBrute(nums);
        System.out.println("Move Zeros Brute: ");
        HelperMethods.printArray(nums);

        moveZerosEnd1.moveZerosOptimal(nums.clone());
        System.out.println("Move Zeros Optimal: ");
        HelperMethods.printArray(nums);
    }
}
