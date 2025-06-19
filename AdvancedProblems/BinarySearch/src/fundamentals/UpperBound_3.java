package fundamentals;

public class UpperBound_3 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int upperBoundBrute(int[] nums, int x) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > x) {
                return i;
            }
        }

        return n;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int upperBoundOptimal(int[] nums, int x) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;
        int lowerBound = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > x) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBound;
    }
    public static void main(String[] args) {
        UpperBound_3 upperBound3 = new UpperBound_3();
        int[] nums = {2, 3, 6, 7, 8, 8, 11, 11, 11, 12};
        int x = 6;

        int upperBoundBrute = upperBound3.upperBoundBrute(nums, x);
        System.out.print("Upper Bound Brute: ");
        System.out.println(upperBoundBrute);

        int upperBoundOptimal = upperBound3.upperBoundOptimal(nums, x);
        System.out.print("Upper Bound Optimal: ");
        System.out.println(upperBoundOptimal);
    }
}
