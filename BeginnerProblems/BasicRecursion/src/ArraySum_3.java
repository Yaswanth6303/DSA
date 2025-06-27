public class ArraySum_3 {
    public int sum(int[] nums, int left) {
        if (left >= nums.length) {
            return 0;
        }
        return nums[left] + sum(nums, left + 1);
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int arraySum(int[] nums) {
        return sum(nums, 0);
    }
    public static void main(String[] args) {
        ArraySum_3 solution = new ArraySum_3();
        int[] nums = {1, 2, 3};
        int result = solution.arraySum(nums);
        System.out.print("Sum of the array is: ");
        System.out.println(result);
    }
}
