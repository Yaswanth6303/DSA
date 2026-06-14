package monotonicStack;

import java.util.Stack;

public class SumOfSubArraysRanges_5 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public long sumSubarrayRangesBrute(int[] nums) {
        int n = nums.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int j = i; j < n; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum = sum + (max - min);
            }
        }

        return sum;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public long sumSubarrayRangesOptimal(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }

    private int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }

    private int[] findNGE(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return result;
    }

    private int[] findPSEE(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    private int[] findPGEE(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return result;
    }

    private long sumSubarrayMins(int[] nums) {
        int[] nse = findNSE(nums);
        int[] psee = findPSEE(nums);

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            long left = i - psee[i];
            long right = nse[i] - i;

            sum += left * right * nums[i];
        }

        return sum;
    }

    private long sumSubarrayMaxs(int[] nums) {
        int[] nge = findNGE(nums);
        int[] pgee = findPGEE(nums);

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            long left = i - pgee[i];
            long right = nge[i] - i;

            sum += left * right * nums[i];
        }

        return sum;
    }

    static void main() {
        SumOfSubArraysRanges_5 solution = new SumOfSubArraysRanges_5();
        int[] nums = {1, 4, 3, 2};
        long result = solution.sumSubarrayRangesBrute(nums);
        System.out.println("The sum of subarray ranges is(Brute): " + result);

        long resultOptimal = solution.sumSubarrayRangesOptimal(nums);
        System.out.println("The sum of subarray ranges is(Optimal): " + resultOptimal);
    }
}
