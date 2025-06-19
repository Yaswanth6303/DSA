package logicBuilding;

public class SingleElementInSortedArray_8 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int singleNonDuplicateBruteI(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else if (i == n - 1) {
                if (nums[i] != nums[i - 1]){
                    return nums[i];
                }
            } else {
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            }
        }

        return -1;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int singleNonDuplicateOptimal(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 2] != nums[n - 1]) return nums[n - 1];

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            /*
            * { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 }
            * (index, index)
            * (even, odd) -> Element is on right half. Eliminate left side.
            * (odd, even) -> Element is on left half. Eliminate right side
            * */
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0) && nums[mid] == nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        SingleElementInSortedArray_8 solver = new SingleElementInSortedArray_8();
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

        System.out.print("Single element in the sorted array is(BruteI): ");
        int singleNonDuplicateBrute = solver.singleNonDuplicateBruteI(nums);
        System.out.println(singleNonDuplicateBrute);

        System.out.print("Single element in the sorted array is(Optimal): ");
        int singleNonDuplicateOptimal = solver.singleNonDuplicateOptimal(nums);
        System.out.println(singleNonDuplicateOptimal);
    }
}
