public class QuickSort_5 {
    public int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int pivot = nums[low];

        while (i < j) {
            while (i < high && nums[i] <= pivot) i++;
            while (j >= low && nums[j] > pivot) j--;

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, low, j);
        return j;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void quickSortHelper(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(nums, low, high);
            quickSortHelper(nums, low, partitionIndex - 1);
            quickSortHelper(nums, partitionIndex + 1, high);
        }
    }
    public int[] quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
        return nums;
    }
    public static void main(String[] args) {
        QuickSort_5 quickSort5 = new QuickSort_5();
        int[] nums = {5, 1, 4, 3, 2};
        int[] sortedArrayMergeSort = quickSort5.quickSort(nums);
        System.out.print("Quick Sort: ");
        HelperMethods.printArray(sortedArrayMergeSort);
    }
}
