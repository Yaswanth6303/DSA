package logicBuilding;

public class FirstLastOccurrence_3 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] searchRangeLinearSearch(int[] nums, int target) {
        int n = nums.length;
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                if (firstOccurrence == -1) {
                    firstOccurrence = i;
                }
                lastOccurrence = i;
            }
        }

        return new int[]{firstOccurrence, lastOccurrence};
    }
    public int lowerBound(int[] nums, int x) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;
        int lowerBound = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= x) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBound;
    }
    public int upperBound(int[] nums, int x) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int lowerBound = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > x) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBound;
    }
    /**
     * Time Complexity: 2 * O(log n)
     * Space Complexity: O(1)
     */
    public int[] searchRangeUsingBounds(int[] nums, int target) {
        int firstOccurrence = lowerBound(nums, target);
        int lastOccurrence = upperBound(nums, target) - 1;

        // Check if the target exists at the firstOccurrence index
        if (firstOccurrence >= nums.length || nums[firstOccurrence] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{firstOccurrence, lastOccurrence};
    }
    public int firstOccurrence(int[] nums, int target) {
        int n = nums.length;

        int firstOccurrence = -1;
        int low = 0;
        int high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == target) {
                firstOccurrence = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return firstOccurrence;
    }
    public int lastOccurrence(int[] nums, int target) {
        int n = nums.length;

        int lastOccurrence = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                lastOccurrence = mid;
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lastOccurrence;
    }
    /**
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int[] searchRangeBinarySearch(int[] nums, int target) {
        int n = nums.length;

        int firstOccurrence = firstOccurrence(nums, target);
        if(firstOccurrence == -1) return new int[]{-1, -1};
        int lastOccurrence = lastOccurrence(nums, target);

        return new int[]{firstOccurrence, lastOccurrence};
    }
    public static void main(String[] args) {
        FirstLastOccurrence_3 firstLastOccurrence3 = new FirstLastOccurrence_3();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 7;

        int[] firstLastIndexLinearSearch = firstLastOccurrence3.searchRangeLinearSearch(nums, target);
        System.out.print("First and Last index in the array(Linear Search): ");
        HelperMethods.printArray(firstLastIndexLinearSearch);

        int[] firstLastIndexUsingBounds = firstLastOccurrence3.searchRangeUsingBounds(nums.clone(), target);
        System.out.print("First and Last index in the array(Using Bounds): ");
        HelperMethods.printArray(firstLastIndexUsingBounds);

        int[] firstLastIndexBinarySearch = firstLastOccurrence3.searchRangeBinarySearch(nums.clone(), target);
        System.out.print("First and Last index in the array(Binary Search): ");
        HelperMethods.printArray(firstLastIndexBinarySearch);
    }
}
