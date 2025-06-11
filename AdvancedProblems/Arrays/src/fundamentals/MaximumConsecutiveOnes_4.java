package fundamentals;

public class MaximumConsecutiveOnes_4 {
    /**
     * Time Complexity -> O(n)
     * Space Complexity -> O(1)
     */
    public int maxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxCount = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }

        return maxCount;
    }
    public static void main(String[] args) {
        MaximumConsecutiveOnes_4 maximumConsecutiveOnes4 = new MaximumConsecutiveOnes_4();
        int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1};

        int maxOnes = maximumConsecutiveOnes4.maxConsecutiveOnes(nums);
        System.out.print("Maximum ones in the array is: ");
        System.out.println(maxOnes);
    }
}
