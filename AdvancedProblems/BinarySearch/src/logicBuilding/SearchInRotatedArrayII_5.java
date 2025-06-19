package logicBuilding;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchInRotatedArrayII_5 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean searchInARotatedSortedArrayIIBrute(ArrayList<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == k) {
                return true;
            }
        }

        return false;
    }

    /**
     * Time Complexity: The worst-case time complexity is O(n), which occurs when
     * the array contains many duplicate elements; the average time complexity
     * is O(log n).
     * Space Complexity: O(1)
     */
    public boolean searchInARotatedSortedArrayIIOptimal(ArrayList<Integer> nums, int k) {
        int n = nums.size();
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums.get(mid) == k) {
                return true;
            }

            // Handle duplicates: if arr[low], arr[mid], and arr[high] are equal
            if (nums.get(low).equals(nums.get(mid)) && nums.get(mid).equals(nums.get(high))) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) <= k && k <= nums.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums.get(mid) <= k && k <= nums.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        SearchInRotatedArrayII_5 solver = new SearchInRotatedArrayII_5();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(7, 8, 1, 2, 3, 3, 3, 4, 5, 6));
        int k = 3;

        boolean searchTargetBrute = solver.searchInARotatedSortedArrayIIBrute(arrayList, k);
        System.out.print("Search Index(Brute): ");
        System.out.println(searchTargetBrute);

        boolean searchTargetOptimal = solver.searchInARotatedSortedArrayIIOptimal(arrayList, k);
        System.out.print("Search Index(Optimal): ");
        System.out.println(searchTargetOptimal);
    }
}
