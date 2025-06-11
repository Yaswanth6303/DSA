import java.util.ArrayList;
import java.util.List;

public class MergeSort_4 {
    public void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;

        List<Integer> mergeList = new ArrayList<>();

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                mergeList.add(nums[left]);
                left++;
            } else {
                mergeList.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            mergeList.add(nums[left]);
            left++;
        }

        while (right <= high) {
            mergeList.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = mergeList.get(i - low);
        }
    }
    public void mergeSortHelper(int[] nums,int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        mergeSortHelper(nums, low, mid);
        mergeSortHelper(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }
    public int[] mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
        return nums;
    }
    public static void main(String[] args) {
        MergeSort_4 mergeSort4 = new MergeSort_4();
        int[] nums = {5, 2, 3, 4, 1};
        int[] sortedArrayMergeSort = mergeSort4.mergeSort(nums);
        System.out.print("Merge Sort: ");
        HelperMethods.printArray(sortedArrayMergeSort);
    }
}
