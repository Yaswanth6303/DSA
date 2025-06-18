import java.util.HashMap;
import java.util.Map;

public class CountSubArrays_3 {
    /**
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int subArraySumBrute(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }

                if (sum == target) {
                    count++;
                }
            }
        }

        return count;
    }
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int subArraySumBetter(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];

                if (sum == target) {
                    count++;
                }
            }
        }

        return count;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int subArraySumOptimal(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        prefixMap.put(0, 1);

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            int sumToRemove = prefixSum - target;
            count += prefixMap.getOrDefault(sumToRemove, 0);
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        CountSubArrays_3 countSubArrays3 = new CountSubArrays_3();
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int target = 3;

        System.out.print("Count Sub-array Brute: ");
        int countSubArrayBrute = countSubArrays3.subArraySumBrute(nums, target);
        System.out.println(countSubArrayBrute);

        System.out.print("Count Sub-array Better: ");
        int countSubArrayBetter = countSubArrays3.subArraySumBetter(nums.clone(), target);
        System.out.println(countSubArrayBetter);

        System.out.print("Count Sub-array Optimal: ");
        int countSubArrayOptimal = countSubArrays3.subArraySumOptimal(nums.clone(), target);
        System.out.println(countSubArrayOptimal);
    }
}
