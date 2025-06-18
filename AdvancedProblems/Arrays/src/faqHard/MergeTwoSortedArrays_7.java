package faqHard;

import java.util.Arrays;

public class MergeTwoSortedArrays_7 {
    /**
     * Time Complexity: O(M + N) + O(M + N)
     * Space Complexity: O(M + N) for using an extra array of size M + N
     */
    public void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int left = 0, right = 0, index = 0;

        while (left < m && right < n) {
            if (nums1[left] <= nums2[right]) {
                merged[index++] = nums1[left++];
            } else {
                merged[index++] = nums2[right++];
            }
        }

        while (left < m) {
            merged[index++] = nums1[left++];
        }

        while (right < n) {
            merged[index++] = nums2[right++];
        }

        for (int i = 0; i < merged.length; i++) {
            nums1[i] = merged[i];
        }
    }
    /**
     * Time Complexity: O(min(M, N)) + O(M x log M) + O(N x log N)
     * Space Complexity: O(1)
     */
    public void mergeOptimal1(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    // Helper for Gap Method
    private void swapIfGreater(int[] nums1, int[] nums2, int i, int j) {
        if (nums1[i] > nums2[j]) {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }
    }

    /**
     * Time Complexity:O((M + N) x log (M + N))
     * Space Complexity: O(1)
     */
    // Gap Method (Shell-Sort style)
    public void mergeOptimal2(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0, right = gap;

            while (right < len) {
                // Case 1: both in nums1
                if (left < m && right < m) {
                    if (nums1[left] > nums1[right]) {
                        swapIfGreater(nums1, nums1, left, right);
                    }
                }
                // Case 2: left in nums1, right in nums2
                else if (left < m && right >= m) {
                    if (nums1[left] > nums2[right - m]) {
                        swapIfGreater(nums1, nums2, left, right - m);
                    }
                }
                // Case 3: both in nums2
                else if (left >= m) {
                    if (nums2[left - m] > nums2[right - m]) {
                        swapIfGreater(nums2, nums2, left - m, right - m);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }

        // Finally copy nums2 into nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays_7 solver = new MergeTwoSortedArrays_7();

        int[] nums1 = new int[9];
        int[] input1 = {1, 3, 5, 7};
        int[] nums2 = {0, 2, 6, 8, 9};
        System.arraycopy(input1, 0, nums1, 0, input1.length);
        int m = input1.length;
        int n = nums2.length;

        System.out.println("Brute Force Merge:");
        System.out.println("Before:");
        System.out.println("nums1: " + Arrays.toString(input1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        solver.mergeBrute(nums1, m, nums2, n);
        System.out.println("After:");
        System.out.println("nums1: " + Arrays.toString(nums1));

        int[] nums3 = new int[9];
        int[] input3 = {1, 3, 5, 7};
        int[] nums4 = {0, 2, 6, 8, 9};
        System.arraycopy(input3, 0, nums3, 0, input3.length);
        System.out.println("Optimal Merge 1 (Swap + Sort):");
        System.out.println("Before:");
        System.out.println("nums3: " + Arrays.toString(input3));
        System.out.println("nums4: " + Arrays.toString(nums4));
        solver.mergeOptimal1(nums3, input3.length, nums4, nums4.length);
        System.out.println("After:");
        System.out.println("nums3: " + Arrays.toString(nums3));

        int[] nums5 = new int[9];
        int[] input5 = {1, 3, 5, 7};
        int[] nums6 = {0, 2, 6, 8, 9};
        System.arraycopy(input5, 0, nums5, 0, input5.length);
        System.out.println("Optimal Merge 2 (Gap Method):");
        System.out.println("Before:");
        System.out.println("nums5: " + Arrays.toString(input5));
        System.out.println("nums6: " + Arrays.toString(nums6));
        solver.mergeOptimal2(nums5, input5.length, nums6, nums6.length);
        System.out.println("After:");
        System.out.println("nums5: " + Arrays.toString(nums5));
    }
}
