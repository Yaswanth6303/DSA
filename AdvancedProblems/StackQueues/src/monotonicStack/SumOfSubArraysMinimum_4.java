package monotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SumOfSubArraysMinimum_4 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int sumSubarrayMinimumBrute(int[] nums) {
        int n = nums.length;
        int mod = (int) 1e9 + 7;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int minimum = nums[i];
            sum = (sum + minimum) % mod;

            for (int j = i + 1; j < n; j++) {
                minimum = Math.min(minimum, nums[j]);
                sum = (sum + minimum) % mod;
            }
        }
        return sum;
    }

    private int[] findNSE(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? n : stack.peek();
            stack.add(i);
        }
        return result;
    }

    private int[] findPSEE(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
                stack.pollLast();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        return result;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int sumSubarrayMinimumOptimal(int[] nums) {
        int n = nums.length;
        int mod = (int) 1e9 + 7;
        long sum = 0;

        int[] nse = findNSE(nums);
        int[] pse = findPSEE(nums);

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum = (sum + left * right * nums[i]) % mod;
        }
        return (int) sum;
    }

     static void main(String[] args) {
        SumOfSubArraysMinimum_4 solution = new SumOfSubArraysMinimum_4();

        int[] nums = {3, 1, 2, 4};
         System.out.println("The sum of minimum value in each subarray is(Brute): " + solution.sumSubarrayMinimumBrute(nums));

        int[] numsOptimal = {1, 4, 6, 7, 3, 7, 8, 1};
        System.out.println("The sum of minimum value in each subarray is(Optimal): " + solution.sumSubarrayMinimumOptimal(numsOptimal));
    }
}
