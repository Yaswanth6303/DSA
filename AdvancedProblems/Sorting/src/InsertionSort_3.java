public class InsertionSort_3 {
    public int[] insertionSortMethod1(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && nums[j - 1] > nums[j]) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
        return nums;
    }
    public int[] insertionSortMethod2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        InsertionSort_3 insertionSort3 = new InsertionSort_3();
        int[] nums = {5, 2, 3, 4, 1};
        System.out.print("Insertion Sort(Method1): ");
        int[] sortedArrayInsertionSortMethod1 = insertionSort3.insertionSortMethod1(nums.clone());
        HelperMethods.printArray(sortedArrayInsertionSortMethod1);
        System.out.print("Insertion Sort(Method2): ");
        int[] sortedArrayInsertionSortMethod2 = insertionSort3.insertionSortMethod2(nums.clone());
        HelperMethods.printArray(sortedArrayInsertionSortMethod2);
    }
}
