public class QuickSort_5 {
    public int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int pivot = nums[low];

        while (i < j) {
            while (i <= high - 1 && nums[i] <= pivot) i++;
            while (j >= low + 1 && nums[j] > pivot) j--;

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
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
        int[] nums = {5, 2, 3, 4, 1};
        int[] sortedArrayMergeSort = quickSort5.quickSort(nums);
        System.out.print("Quick Sort: ");
        HelperMethods.printArray(sortedArrayMergeSort);
    }
}
