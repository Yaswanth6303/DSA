package substringProblems;

public class BinarySubarraysWithSum_2 {
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
    static void main() {
        BinarySubarraysWithSum_2 obj = new BinarySubarraysWithSum_2();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int result = obj.numSubarraysWithSumBrute(nums, goal);
        System.out.println("Number of substrings with sum \"" + goal + "\" is: " + result);
    }
}
