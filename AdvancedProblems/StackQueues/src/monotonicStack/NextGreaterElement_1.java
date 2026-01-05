package monotonicStack;

import java.util.Stack;

public class NextGreaterElement_1 {
    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int[] nextLargerElementBrute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    break;
                } else {
                    result[i] = -1;
                }
            }
        }

        return result;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] nextLargerElementOptimal(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(nums[i]);
        }

        return result;
    }
    static void main() {
        NextGreaterElement_1 solution = new NextGreaterElement_1();
        int[] nums = {6, 0, 8, 1, 3};
        int[] resultBrute = solution.nextLargerElementBrute(nums);
        System.out.println("The next greater elements are (Brute): ");
        printArray(resultBrute);

        int[] numsOptimal = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        int[] resultOptimal = solution.nextLargerElementOptimal(numsOptimal);
        System.out.println("The next greater elements are (Optimal): ");
        printArray(resultOptimal);
    }
}
