package fundamentals;

import java.util.Arrays;

public class LargestElement_2 {
    /**
     * Time Complexity -> O(n * log n)
     * Space Complexity -> O(1)
     */
    public int largestElementBrute(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public int largestElementOptimal(int[] nums) {
        int n = nums.length;
        int largestElement = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > largestElement) {
                largestElement = nums[i];
            }
        }

        return largestElement;
    }
    public static void main(String[] args) {
        LargestElement_2 largestElement2 = new LargestElement_2();
        int[] nums = {1, 2, 4, 7, 7, 5};

        int largestElementBrute = largestElement2.largestElementBrute(nums);
        System.out.print("Largest element in the array is(Brute): ");
        System.out.println(largestElementBrute);

        int largestElementOptimal = largestElement2.largestElementOptimal(nums.clone());
        System.out.print("Largest element in the array is(Optimal): ");
        System.out.println(largestElementOptimal);
    }
}
