package fundamentals;

public class LeftRotateArrayByK_6 {
    /**
     * Time Complexity -> O(n - k) + O(k) = O(n)
     * Space Complexity -> O(n)
     */
    public int[] rotateArrayBrute_1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] rotatedArray = new int[n];
        int j = 0;

        for (int i = k; i < n; i++) {
            rotatedArray[j++] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            rotatedArray[j++] = nums[i];
        }

        return rotatedArray;
    }
    /**
     * Time Complexity -> O(k) + O(n-k) + O(k) = O(n+k)
     * Space Complexity -> O(k)
     */
    public void rotateArrayBrute_2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[k];

        // Store 0 -> k
        for(int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        // Put k -> n at starting
        for(int i = k; i < n; i++) {
            nums[i - k] = nums[i];
        }

        // Put the temp array after putting k -> n at the starting
        for(int i = n - k; i < n; i++) {
            nums[i] = temp[i - (n - k)];
        }
    }

    public void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    /**
     * Time Complexity -> O(k) + O(n - k) + O(n) = O(2n)
     * Space Complexity -> O(1)
     */
    public void rotateArrayOptimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
        reverseArray(nums, 0, n - 1);

    }
    public static void main(String[] args) {
        LeftRotateArrayByK_6 leftRotateArrayByK6 = new LeftRotateArrayByK_6();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int[] rotateArrayBrute_1 = leftRotateArrayByK6.rotateArrayBrute_1(nums, k);
        System.out.print("Rotate Array Brute: ");
        HelperMethods.printArray(rotateArrayBrute_1);

        int[] numsMethod2 = {1, 2, 3, 4, 5};
        leftRotateArrayByK6.rotateArrayBrute_2(numsMethod2, k);
        System.out.print("Rotate Array Better: ");
        HelperMethods.printArray(numsMethod2);

        int[] numsOptimal = {1, 2, 3, 4, 5, 6, 7};
        leftRotateArrayByK6.rotateArrayOptimal(numsOptimal, k);
        System.out.print("Rotate Array Optimal: ");
        HelperMethods.printArray(numsOptimal);
    }
}
