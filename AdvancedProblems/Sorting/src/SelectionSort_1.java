public class SelectionSort_1 {
    public int[] selectionSort(int[] nums, String order) {
        if (!order.equals("ao") && !order.equals("do")) {
            System.out.println("Invalid sorting order. Use 'ao' for ascending or 'do' for descending.");
            return nums;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (order.equals("ao")) {
                    if (nums[minIndex] > nums[j]) {
                        minIndex = j;
                    }
                } else if (order.equals("do")) {
                    if (nums[minIndex] < nums[j]) {
                        minIndex = j;
                    }
                }
            }

            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        SelectionSort_1 selectionSort1 = new SelectionSort_1();
        int[] nums = {5, 2, 3, 4, 1};

        // Try with "ao", "do", and an invalid input like "random"
        int[] sortedArraySelectionSort = selectionSort1.selectionSort(nums, "ao");

        System.out.print("Selection Sort: ");
        HelperMethods.printArray(sortedArraySelectionSort);
    }
}
