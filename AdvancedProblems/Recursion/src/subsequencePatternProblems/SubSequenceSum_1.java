package subsequencePatternProblems;

public class SubSequenceSum_1 {
    public boolean solve(int i, int n, int[] nums, int k) {
        // Base case: if the sum k is 0, a subsequence is found
        if (k == 0) {
            return true;
        }
        // Base case: if k is negative, no valid subsequence can be found
        if (k < 0) {
            return false;
        }
        // Base case: if all elements are processed, check if k is 0
        if (i == n) {
            return k == 0;
        }
        // Recursive call: include the current element in the subsequence
        // or exclude the current element from the subsequence
        return solve(i + 1, n, nums, k - nums[i]) || solve(i + 1, n, nums, k);
    }
    /**
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     */
    public boolean checkSubsequenceSum(int[] nums, int target) {
        int n = nums.length;
        return solve(0, n, nums, target);
    }
    public static void main(String[] args) {
        SubSequenceSum_1 solution = new SubSequenceSum_1();
        int[] nums = {1, 2, 3, 4};
        int target = 8;
        System.out.print("Array contains subsequence sum: ");
        System.out.println(solution.checkSubsequenceSum(nums, target));
    }
}
