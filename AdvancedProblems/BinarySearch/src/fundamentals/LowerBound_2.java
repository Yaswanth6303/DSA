package fundamentals;

public class LowerBound_2 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int lowerBoundBrute(int[] nums, int x) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= x) {
                return i;
            }
        }

        return n;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int lowerBoundOptimal(int[] nums, int x) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;
        int lowerBound = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBound;
    }
    public static void main(String[] args) {
        LowerBound_2 lowerBound2 = new LowerBound_2();
        int[] nums = {1, 2, 3, 3, 7, 8, 9, 9, 9, 11};
        int x = 11;

        int lowerBoundBrute = lowerBound2.lowerBoundBrute(nums, x);
        System.out.print("Lower Bound Brute: ");
        System.out.println(lowerBoundBrute);

        System.out.print("Lower Bound Optimal: ");
        int lowerBoundOptimal = lowerBound2.lowerBoundOptimal(nums, x);
        System.out.println(lowerBoundOptimal);
    }
}
