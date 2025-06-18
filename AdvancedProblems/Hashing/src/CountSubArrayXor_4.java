import java.util.HashMap;
import java.util.Map;

public class CountSubArrayXor_4 {
    /**
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int subArraysWithXorKBrute(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor = xor ^ nums[k];
                }
                if (xor == target) {
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
    public int subArraysWithXorKBetter(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor ^ nums[j];

                if (xor == target) {
                    count++;
                }
            }
        }

        return count;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int countSubArraysWithXorOptimal(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> prefixXorMap = new HashMap<>();
        int xor = 0;
        int count = 0;

        prefixXorMap.put(0, 1); // Base case: for prefix XOR directly equal to target

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];

            int required = xor ^ target;
            count += prefixXorMap.getOrDefault(required, 0);

            prefixXorMap.put(xor, prefixXorMap.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubArrayXor_4 solver = new CountSubArrayXor_4();
        int[] nums = {4, 2, 2, 6, 4};
        int target = 6;
        int countSubArrayBrute = solver.subArraysWithXorKBrute(nums, target);
        System.out.print("Count sub-array Brute: ");
        System.out.println(countSubArrayBrute);

        int countSubArrayBetter = solver.subArraysWithXorKBetter(nums.clone(), target);
        System.out.print("Count sub-array Better: ");
        System.out.println(countSubArrayBetter);

        int countSubArrayOptimal = solver.countSubArraysWithXorOptimal(nums.clone(), target);
        System.out.print("Count sub-array Optimal: ");
        System.out.println(countSubArrayOptimal);
    }
}
