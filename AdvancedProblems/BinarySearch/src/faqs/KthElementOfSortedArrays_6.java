package faqs;

public class KthElementOfSortedArrays_6 {
    /**
     * Brute Force Approach:
     * Time Complexity: O(n1 + n2)
     * Space Complexity: O(n1 + n2)
     */
    public int kthElementBrute(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int i = 0, j = 0, index = 0;
        int[] mergedArray = new int[n];

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                mergedArray[index++] = nums1[i++];
            } else {
                mergedArray[index++] = nums2[j++];
            }
        }

        while (i < n1) {
            mergedArray[index++] = nums1[i++];
        }

        while (j < n2) {
            mergedArray[index++] = nums2[j++];
        }

        if (k >= 1 && k <= mergedArray.length) {
            return mergedArray[k - 1]; // k is 1-based index
        }

        return -1;
    }
    /**
     * Better Approach (No extra space):
     * Time Complexity: O(k)
     * Space Complexity: O(1)
     */
    public int kthElementBetter(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                count++;
                if (count == k) return nums1[i];
                i++;
            } else {
                count++;
                if (count == k) return nums2[j];
                j++;
            }
        }

        while (i < n1) {
            count++;
            if (count == k) return nums1[i];
            i++;
        }

        while (j < n2) {
            count++;
            if (count == k) return nums2[j];
            j++;
        }

        return -1;
    }

    /**
     * Optimal Approach (Binary Search):
     * Time Complexity: O(log(min(n1, n2)))
     * Space Complexity: O(1)
     */
    public int kthElementOptimal(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) return kthElementOptimal(nums2, nums1, k); // Ensure nums1 is smaller

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 > r2) {
                high = mid1 - 1;
            } else if (l2 > r1){
                low = mid1 + 1;
            } else {
                return Math.max(l1, l2);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        KthElementOfSortedArrays_6 solution = new KthElementOfSortedArrays_6();

        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};

        int k = 5;

        System.out.println("Using Brute Force: " + solution.kthElementBrute(nums1, nums2, k));
        System.out.println("Using Better Approach: " + solution.kthElementBetter(nums1, nums2, k));
        System.out.println("Using Optimal Approach: " + solution.kthElementOptimal(nums1, nums2, k));
    }
}
