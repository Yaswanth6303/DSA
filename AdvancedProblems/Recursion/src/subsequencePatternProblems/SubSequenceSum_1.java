package subsequencePatternProblems;

public class SubSequenceSum_1 {
    public boolean solve(int index, int n, int[] nums, int sum) {
        if (sum == 0) return true;
        if (index == n) return false;
        if (sum < 0) return false;

        boolean path1 = solve(index + 1, n, nums, sum - nums[index]);
        boolean path2 = solve(index + 1, n, nums, sum);
        return path1 || path2;
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
        int[] nums = {1, 4, 3};
        int target = 10;
        System.out.print("Array contains subsequence sum: ");
        System.out.println(solution.checkSubsequenceSum(nums, target));
    }
}
