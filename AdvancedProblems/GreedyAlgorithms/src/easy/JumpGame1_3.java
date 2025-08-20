package easy;

public class JumpGame1_3 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxIndex) {
                break;
            }

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }
    public static void main(String[] args) {
        JumpGame1_3 jumpGame = new JumpGame1_3();
        int[] nums1 = {1, 2, 3, 1, 1, 0, 2, 5};
        int[] nums2 = {1, 2, 4, 1, 1, 0, 2, 4};

        System.out.println(jumpGame.canJump(nums1));
        System.out.println(jumpGame.canJump(nums2));
    }
}
