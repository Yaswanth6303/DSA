public class ReverseArray_7 {
    public void reverse(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        reverse(nums, left + 1, right - 1);
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] reverseArray(int[] nums) {
        reverse(nums, 0, nums.length - 1);
        return nums;
    }
    public static void main(String[] args) {
        ReverseArray_7 solution = new ReverseArray_7();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.print("Reversed Array: ");
        int[] result = solution.reverseArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
