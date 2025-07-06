package subsequencePatternProblems;

public class CountSubSequenceSum_2 {
    public int solve(int index, int n, int[] nums, int sum) {
        if (sum == 0) return 1;
        if (index == n) return 0;
        if (sum < 0) return 0;

        int path1 = solve(index + 1, n, nums, sum - nums[index]);
        int path2 = solve(index + 1, n, nums, sum);
        return path1 + path2;
    }

    /**
     * Time Complexity: O(2^n * n)
     * Space Complexity: O(n)
     */
    public int countSubsequenceSum(int[] nums, int target) {
        int n = nums.length;
        return solve(0, n, nums, target);
    }
    public static void main(String[] args) {
        CountSubSequenceSum_2 solution = new CountSubSequenceSum_2();
        int[] nums = {1, 4, 3};
        int target = 4;
        System.out.print("Array contains " + solution.countSubsequenceSum(nums, target) + " subsequences");
    }
}
