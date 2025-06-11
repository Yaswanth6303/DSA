package faqHard;

import java.util.Arrays;

public class MergeTwoSortedArrays_7 {

    // Brute Force: Using Extra Space
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
            if (i < m) nums1[i] = merged[i];
            else nums2[i - m] = merged[i];
        }
    }

    // Optimal 1: Swap and Sort
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
    }

    // Helper function to swap elements if needed
    private void swapIfGreater(int[] nums1, int[] nums2, int i, int j) {
        if (nums1[i] > nums2[j]) {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }
    }

    // Optimal 2: Gap Method (Shell Sort idea)
    // Function to merge two sorted arrays without using extra space
    public void mergeOptimal2(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = gap;

            while (right < len) {
                // Case 1: i in nums 1 j in num 2
                if (left < m && right >= m) {
                    if (nums1[left] > nums2[right - m]) {
                        swapIfGreater(nums1, nums2, left, right - m);
                    }
                }
                // Case 2: i in nums2 and j in nums2
                else if (left >= m) {
                    if (nums1[left - m] > nums2[right - m]) {
                        swapIfGreater(nums2, nums2, left - m, right - m);
                    }
                }
                // Case 3: i in nums1 and j in nums1
                else {
                    if (nums1[left] > nums1[right]) {
                        swapIfGreater(nums1, nums1, left, right);
                    }
                }
                left++;
                right++;
            }

            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }
    }
    public static void main(String[] args) {
        MergeTwoSortedArrays_7 solver = new MergeTwoSortedArrays_7();

        // ✅ Brute Force
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {0, 2, 6, 8, 9};
        int m = nums1.length;
        int n = nums2.length;

        System.out.println("🔁 Brute Force Merge:");
        System.out.println("Before:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));

        solver.mergeBrute(nums1, m, nums2, n);

        System.out.println("After:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));


        // ✅ Optimal 1: Swap + Sort
        int[] nums3 = {1, 3, 5, 7};
        int[] nums4 = {0, 2, 6, 8, 9};
        System.out.println("\n⚡ Optimal Merge 1 (Swap + Sort):");
        System.out.println("Before:");
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("nums4: " + Arrays.toString(nums4));

        solver.mergeOptimal1(nums3, nums3.length, nums4, nums4.length);

        System.out.println("After:");
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("nums4: " + Arrays.toString(nums4));


        // ✅ Optimal 2: Gap Method
        int[] nums5 = {1, 3, 5, 7};
        int[] nums6 = {0, 2, 6, 8, 9};
        System.out.println("\n🚀 Optimal Merge 2 (Gap Method):");
        System.out.println("Before:");
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("nums6: " + Arrays.toString(nums6));

        solver.mergeOptimal2(nums5, nums5.length, nums6, nums6.length);

        System.out.println("After:");
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("nums6: " + Arrays.toString(nums6));
    }
}
