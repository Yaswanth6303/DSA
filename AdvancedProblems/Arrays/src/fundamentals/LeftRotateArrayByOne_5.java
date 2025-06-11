package fundamentals;

public class LeftRotateArrayByOne_5 {
    public void rotateArrayByOne(int[] nums) {
        int n = nums.length;
        int temp = nums[0];
        for(int i = 1; i < n; i++) {
            nums[i - 1] = nums[i];
        }
        nums[n - 1] = temp;
    }
    public static void main(String[] args) {
        LeftRotateArrayByOne_5 leftRotateArrayByOne5 = new LeftRotateArrayByOne_5();
        int[] nums = {1, 2, 3, 4, 5};
        leftRotateArrayByOne5.rotateArrayByOne(nums);
        HelperMethods.printArray(nums);
    }
}
