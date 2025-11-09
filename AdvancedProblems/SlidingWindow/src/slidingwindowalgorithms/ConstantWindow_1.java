package slidingwindowalgorithms;

public class ConstantWindow_1 {
    public static void slidingWindowSum(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        int l = 0;
        int r = k - 1;

        // Step 1: Calculate initial window sum
        for (int i = l; i <= r; i++) {
            sum += nums[i];
        }
        System.out.println("Sum of window 1: " + sum);

        // Step 2: Slide the window
        while (r < n - 1) {   // stop before r exceeds array size
            sum -= nums[l];   // remove outgoing element
            l++;              // move left pointer
            r++;              // move right pointer
            sum += nums[r];   // add new incoming element

            System.out.println("Sum of window " + (l + 1) + ": " + sum);
        }
    }

    static void main() {
        int[] nums = {1, 3, 2, 6, 4, 8, 5};
        int k = 3;
        slidingWindowSum(nums, k);
    }
}
