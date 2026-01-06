package monotonicStack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2_2 {
    public static void printArray(int[] nums) {
        NextGreaterElement_1.printArray(nums);
    }
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int[] nextGreaterElementsBrute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int index = (i + j) % n;

                if (nums[index] > nums[i]) {
                    result[i] = nums[index];
                    break;
                }
            }
        }

        return result;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] nextGreaterElementsOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;

            while (!stack.isEmpty() && nums[index] >= stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty()) {
                    result[index] = -1;
                } else {
                    result[index] = stack.peek();
                }
            }

            stack.add(nums[index]);
        }

        return result;
    }
    static void main() {
        NextGreaterElement2_2 solution = new NextGreaterElement2_2();
        int[] nums = {2, 10, 12, 1, 11};
        int[] resultBrute = solution.nextGreaterElementsBrute(nums);
        System.out.print("The next greater elements are (Brute): ");
        printArray(resultBrute);

        int[] resultOptimal = solution.nextGreaterElementsOptimal(nums);
        System.out.print("The next greater elements are (Optimal): ");
        printArray(resultOptimal);
    }
}
