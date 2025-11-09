package longestandsmallestwindowproblems;

public class MaxConsecutiveOnesIII_2 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int longestOnesBrute(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) zeros++;
                if (zeros > k) break;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }

        return maxLength;
    }
    /**
     * Time Complexity: O(2n)
     * Space Complexity: O(1)
     */
    public int longestOnesBetter(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int maxLength = 0;
        int zeros = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) zeros++;
            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int longestOnesOptimal(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int maxLength = 0;
        int zeros = 0;

        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) zeros++;
            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
    static void main() {
        MaxConsecutiveOnesIII_2 mc = new MaxConsecutiveOnesIII_2();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println("Longest Ones(Brute): " + mc.longestOnesBrute(nums, k));
        System.out.println("Longest Ones(Better): " + mc.longestOnesBetter(nums, k));
        System.out.println("Longest Ones(Optimal): " + mc.longestOnesOptimal(nums, k));
    }
}
