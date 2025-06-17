package faqHard;

public class CountInversions_4 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public long numberOfInversionsBrute(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
    private long merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int index = 0;

        long count = 0;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
                count += (mid - left + 1);
            }
        }

        while (left <= mid) {
            temp[index++] = nums[left++];
        }

        while (right <= high) {
            temp[index++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, low, high - low + 1);

        return count;
    }
    private long mergeSort(int[] nums, int low, int high) {
        long count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;

            count += mergeSort(nums, low, mid);
            count += mergeSort(nums, mid + 1, high);
            count += merge(nums, low, mid, high);
        }
        return count;
    }
    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public long countInversionsOptimal(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    public static void main(String[] args) {
        CountInversions_4 solver = new CountInversions_4();
        int[] nums = {5, 3, 2, 4, 1};

        System.out.print("Count Inversions Brute: ");
        long countInversionsBrute = solver.numberOfInversionsBrute(nums);
        System.out.println(countInversionsBrute);

        System.out.print("Count Inversions Optimal: ");
        long countInversionsOptimal = solver.countInversionsOptimal(nums);
        System.out.println(countInversionsOptimal);
    }
}
