public class BubbleSort_2 {
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
            // Break only if no swap occurred (already sorted)
            if (!isSwapped) {
                break;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        BubbleSort_2 bubbleSort2 = new BubbleSort_2();
        int[] nums = {5, 2, 3, 4, 1};
        System.out.print("Bubble Sort(Method1): ");
        int[] sortedArrayBubbleSortMethod1 = bubbleSort2.bubbleSortMethod1(nums.clone());
        HelperMethods.printArray(sortedArrayBubbleSortMethod1);
        System.out.print("Bubble Sort(Method2): ");
        int[] sortedArrayBubbleSortMethod2 = bubbleSort2.bubbleSortMethod2(nums.clone());
        HelperMethods.printArray(sortedArrayBubbleSortMethod2);
        System.out.print("Bubble Sort Optimal: ");
        int[] sortedArrayBubbleSortOptimal = bubbleSort2.bubbleSortOptimal(nums.clone());
        HelperMethods.printArray(sortedArrayBubbleSortOptimal);
    }
}
