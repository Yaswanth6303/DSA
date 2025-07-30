package onanswers;

public class KthMissingNumber_7 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int findKthPositiveBrute(int[] nums, int k) {
        int n = nums.length;

        int count = 0;
        int num = 1;

        while (true) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (nums[i] == num) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                count++;
                if (count == k) {
                    return num;
                }
            }

            num++;
        }
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findKthPositiveBetter(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= k) k++;
             else break;
        }

        return k;
    }

    /**
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int findKthPositiveOptimal(int[] nums, int k) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Place the pointers in those 2 indices such a way that answer lies b/w those two indices
            int missing = nums[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return k + high + 1;
    }

    public static void main(String[] args) {
        KthMissingNumber_7 solver = new KthMissingNumber_7();
        int[] nums = {2, 3, 4, 7, 11};
        int k = 5;

        System.out.print("Brute Approach: ");
        System.out.println(solver.findKthPositiveBrute(nums, k));

        System.out.print("Better Approach: ");
        System.out.println(solver.findKthPositiveBetter(nums, k));

        System.out.print("Optimal Approach: ");
        System.out.println(solver.findKthPositiveOptimal(nums.clone(), k));
    }
}
