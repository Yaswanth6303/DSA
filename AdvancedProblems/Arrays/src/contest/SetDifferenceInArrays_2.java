package contest;

import java.util.*;

/**
 * Class to find the symmetric difference between two arrays.
 * It provides three different approaches: brute force, better with sets, and optimal using two-pointer technique.
 */
public class SetDifferenceInArrays_2 {

    /**
     * Finds the symmetric difference between two arrays using a brute force approach.
     *
     * Time Complexity: O(n1 * n2)
     * Space Complexity: O(n1 + n2)
     *
     * @param nums1 First sorted integer array
     * @param nums2 Second sorted integer array
     * @return Sorted array of elements present in exactly one of the input arrays
     */
    public static int[] setDifferenceBrute(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] visited1 = new int[n1];
        int[] visited2 = new int[n2];
        List<Integer> diffList = new ArrayList<>();

        // Mark matching elements as visited
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums2[j]) { // FIXED: removed check for visited2[j]
                    visited1[i] = 1;
                    visited2[j] = 1;
                    break;
                } else if (nums2[j] > nums1[i]) {
                    break;
                }
            }
        }

        // Add unique elements from nums1
        for (int i = 0; i < n1; i++) {
            if (visited1[i] == 0 && (diffList.isEmpty() || diffList.get(diffList.size() - 1) != nums1[i])) {
                diffList.add(nums1[i]);
            }
        }

        // Add unique elements from nums2
        for (int j = 0; j < n2; j++) {
            if (visited2[j] == 0 && (diffList.isEmpty() || diffList.get(diffList.size() - 1) != nums2[j])) {
                diffList.add(nums2[j]);
            }
        }

        // Sort and return the result
        return diffList.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Uses HashSet to find symmetric difference.
     *
     * @param nums1 First integer array
     * @param nums2 Second integer array
     * @return Sorted array of elements present in exactly one of the input arrays
     */
    public static int[] setDifferenceBetter(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        Set<Integer> result = new TreeSet<>();

        for (int num : set1) {
            if (!set2.contains(num)) result.add(num);
        }
        for (int num : set2) {
            if (!set1.contains(num)) result.add(num);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Two-pointer optimized approach for sorted arrays.
     *
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return Sorted array of elements present in exactly one of the input arrays
     */
    public static int[] setDifferenceOptimal(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i])
                    result.add(nums1[i]);
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != nums2[j])
                    result.add(nums2[j]);
                j++;
            } else {
                int val = nums1[i];
                while (i < nums1.length && nums1[i] == val) i++;
                while (j < nums2.length && nums2[j] == val) j++;
            }
        }

        while (i < nums1.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != nums1[i])
                result.add(nums1[i]);
            i++;
        }

        while (j < nums2.length) {
            if (result.isEmpty() || result.get(result.size() - 1) != nums2[j])
                result.add(nums2[j]);
            j++;
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 5, 7, 9};
        int[] nums2 = {1, 3, 4, 7};

        System.out.println("Test Case 1:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Brute Force: " + Arrays.toString(setDifferenceBrute(nums1, nums2)));
        System.out.println("Better: " + Arrays.toString(setDifferenceBetter(nums1, nums2)));
        System.out.println("Optimal: " + Arrays.toString(setDifferenceOptimal(nums1, nums2)));

        // Test case 2
        int[] nums3 = {1, 2, 6, 6};
        int[] nums4 = {-2, 2, 3, 4, 6};

        System.out.println("\nTest Case 2:");
        System.out.println("nums1: " + Arrays.toString(nums3));
        System.out.println("nums2: " + Arrays.toString(nums4));
        System.out.println("Brute Force: " + Arrays.toString(setDifferenceBrute(nums3, nums4)));
        System.out.println("Better: " + Arrays.toString(setDifferenceBetter(nums3, nums4)));
        System.out.println("Optimal: " + Arrays.toString(setDifferenceOptimal(nums3, nums4)));
    }
}
