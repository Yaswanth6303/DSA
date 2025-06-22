package faqs;

public class MedianOf2SortedArrays_4 {
    /**
     * Time Complexity: O(n1 + n2)
     * Space Complexity: O(n1 + n2)
     */
    public double medianBrute(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;

        int[] merged = new int[n1 + n2];

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < n1) {
            merged[k++] = nums1[i++];
        }

        while (j < n2) {
            merged[k++] = nums2[j++];
        }

        int n = merged.length;
        if (n % 2 == 1) {
            return (double) merged[n / 2];
        } else {
            return ((double) merged[n / 2] + merged[(n / 2) - 1]) / 2.0;
        }
    }
    /**
     * Time Complexity: O(n1 + n2)
     * Space Complexity: O(1)
     */
    public double medianBetter(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int i = 0;
        int j = 0;
        int count = 0;
        int index_2 = n / 2;
        int index_1 = index_2 - 1;

        int index1Element = -1;
        int index2Element = -1;
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                if (count == index_1) index1Element = nums1[i];
                if (count == index_2) index2Element = nums1[i];
                count++;
                i++;
            } else {
                if (count == index_1) index1Element = nums2[j];
                if (count == index_2) index2Element = nums2[j];
                count++;
                j++;
            }
        }

        while (i < n1) {
            if (count == index_1) index1Element = nums1[i];
            if (count == index_2) index2Element = nums1[i];
            count++;
            i++;
        }

        while (j < n2) {
            if (count == index_1) index1Element = nums2[j];
            if (count == index_2) index2Element = nums2[j];
            count++;
            j++;
        }

        if (n % 2 == 1) {
            return (double) index2Element;
        } else {
            return (double) ((double) (index1Element + index2Element)) / 2.0;
        }
    }

    /**
     * Time Complexity: O(log(min(n1, n2)))
     * Space Complexity: O(1)
     */
    public double medianOptimal(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        if (n1 > n2) return medianOptimal(nums2, nums1);

        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1) / 2;

        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        MedianOf2SortedArrays_4 solver = new MedianOf2SortedArrays_4();
        int[] nums1 = {1, 3, 4, 7, 10, 12};
        int[] nums2 = {2, 3, 6 ,15};

        System.out.print("Median of the array is (Brute): ");
        double medianBrute = solver.medianBrute(nums1, nums2);
        System.out.println(medianBrute);

        System.out.print("Median of the array is (Better): ");
        double medianBetter = solver.medianBetter(nums1.clone(), nums2.clone());
        System.out.println(medianBetter);

        int[] nums3 = {7, 12, 14, 15};
        int[] nums4 = {1, 2, 3, 4, 9, 11};
        System.out.print("Median of the array is (Optimal): ");
        double medianOptimal = solver.medianBetter(nums3, nums4);
        System.out.println(medianOptimal);
    }
}
