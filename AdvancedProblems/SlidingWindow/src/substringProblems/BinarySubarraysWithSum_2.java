package substringProblems;

public class BinarySubarraysWithSum_2 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int numSubarraysWithSumBrute(int[] nums, int goal) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                }
            }
        }

        return count;
    }

    private int numSubarraysWithSumLessEqualToGoal(int[] nums, int goal) {
        if (goal < 0) return 0;

        int n = nums.length;
        int l = 0;
        int sum = 0;
        int count = 0;

        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += (r - l + 1);
        }

        return count;
    }

    /**
     * Time Complexity: O(2 * 2n)
     * Space Complexity: O(1)
     */
    public int numSubarraysWithSumOptimal(int[] nums, int goal) {
        return numSubarraysWithSumLessEqualToGoal(nums, goal) - numSubarraysWithSumLessEqualToGoal(nums, goal - 1);
    }

    static void main() {
        BinarySubarraysWithSum_2 obj = new BinarySubarraysWithSum_2();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int resultBrute = obj.numSubarraysWithSumBrute(nums, goal);
        int resultOptimal = obj.numSubarraysWithSumOptimal(nums, goal);
        System.out.println("Number of substrings with sum \"" + goal + "\" is(Brute): " + resultBrute);
        System.out.println("Number of substrings with sum \"" + goal + "\" is(Optimal): " + resultOptimal);
    }
}
