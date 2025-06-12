package faqMedium;

import fundamentals.HelperMethods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_8 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) as the extra space used is constant, only storing a fixed-size array.
     */
    public int[] twoSumBrute(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
    /**
     * Time Complexity:
     * - Average Case: O(n)
     *     - We traverse the array once → O(n)
     *     - HashMap operations (put, containsKey) take O(1) on average.
     *     - So overall time complexity is O(n)
     *
     * - Worst Case: O(n^2)
     *     - In rare cases, due to too many hash collisions, HashMap operations can degrade to O(n)
     *     - Then each lookup could take O(n), and with n iterations, total time becomes O(n^2)
     *
     * - Using TreeMap Instead of HashMap: O(n * log n)
     *     - TreeMap operations (put, get, containsKey) take O(log n) as it uses Red-Black Tree
     *     - So overall time is O(n * log n)

     * Space Complexity:
     * - O(n)
     *     - In the worst case, we store all elements in the map
     *     - So space grows linearly with input size
     */
    public int[] twoSumBetter(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int moreNeeded = target - num;

            if (mpp.containsKey(moreNeeded)) {
                return new int[]{mpp.get(moreNeeded), i};
            }

            mpp.put(num, i);
        }

        return new int[]{-1, -1};
    }
    /**
     * Time Complexity: O(n) + O(n * log n)
     * Space Complexity: O(n)
     */
    public int[] twoSumOptimal(int[] nums, int target) {
       int n = nums.length;

       int[][] elementIndex = new int[n][2];

       for (int i = 0; i < n; i++) {
           elementIndex[i][0] = nums[i];
           elementIndex[i][1] = i;
       }

       // HelperMethods.printMatrix(elementIndex);

       Arrays.sort(elementIndex, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return Integer.compare(o1[0], o2[0]);
           }
       });

       int left = 0;
       int right = n - 1;

       while (left < right) {
           int sum = elementIndex[left][0] + elementIndex[right][0];

           if (sum == target) {
               return new int[]{elementIndex[left][1], elementIndex[right][1]};
           } else if (sum < target) {
               left++;
           } else {
               right--;
           }
       }

       return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        TwoSum_8 twoSum8 = new TwoSum_8();
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;

        int[] twoSumBrute = twoSum8.twoSumBrute(nums, target);
        System.out.print("Two Sum Brute: ");
        HelperMethods.printArray(twoSumBrute);

        int[] twoSumBetter = twoSum8.twoSumBetter(nums.clone(), target);
        System.out.print("Two Sum Better: ");
        HelperMethods.printArray(twoSumBetter);

        int[] twoSumOptimal = twoSum8.twoSumOptimal(nums.clone(), target);
        System.out.print("Two Sum Optimal: ");
        HelperMethods.printArray(twoSumOptimal);
    }
}
