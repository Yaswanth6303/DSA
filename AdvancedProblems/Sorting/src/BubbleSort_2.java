public class BubbleSort_2 {
    // Method 1: Basic Bubble Sort (forward pass)
    public int[] bubbleSortMethod1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    // Method 2: Bubble Sort (reverse outer loop style)
    public int[] bubbleSortMethod2(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    // Optimal Bubble Sort with early stopping if already sorted
    public int[] bubbleSortOptimal(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
        return nums;
    }

    // Recursive Bubble Sort
    public static void bubbleSortRecursive(int[] nums, int n) {
        if (n == 1) return;

        boolean isSwapped = false;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                isSwapped = true;
            }
        }

        if (!isSwapped) return;

        bubbleSortRecursive(nums, n - 1);
    }

    public static int[] bubbleSort(int[] nums) {
        bubbleSortRecursive(nums, nums.length);
        return nums;
    }

    public static void main(String[] args) {
        BubbleSort_2 bubbleSort2 = new BubbleSort_2();
        int[] nums = {5, 2, 3, 4, 1};

        System.out.print("Bubble Sort (Method 1): ");
        int[] sorted1 = bubbleSort2.bubbleSortMethod1(nums.clone());
        HelperMethods.printArray(sorted1);

        System.out.print("Bubble Sort (Method 2): ");
        int[] sorted2 = bubbleSort2.bubbleSortMethod2(nums.clone());
        HelperMethods.printArray(sorted2);

        System.out.print("Bubble Sort (Optimal): ");
        int[] sorted3 = bubbleSort2.bubbleSortOptimal(nums.clone());
        HelperMethods.printArray(sorted3);

        System.out.print("Bubble Sort (Recursive): ");
        int[] sorted4 = bubbleSort(nums.clone());
        HelperMethods.printArray(sorted4);
    }
}
