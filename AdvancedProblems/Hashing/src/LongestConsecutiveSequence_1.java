import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_1 {
    public boolean linearSearch(int[] nums, int x) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                return true;
            }
        }
        return false;
    }
    /**
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int longestConsecutiveSequenceBrute(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int longest = 1;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int count = 1;
            while (linearSearch(nums, x + 1)) {
                x += 1;
                count += 1;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
    /**
     * Time Complexity: O(n) + O(n log n)
     * Space Complexity: O(1)
     */
    public int longestConsecutiveSequenceBetter(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        Arrays.sort(nums);

        int longest = 1;
        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] - 1 == lastSmaller) {
                count += 1;
                lastSmaller = nums[i];
            } else if(nums[i] != lastSmaller) {
                count = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, count);
        }

        return longest;
    }
    /**
     * Time Complexity: O(N) + O(2N) = O(3N)
     * Space Complexity: O(N)
     */
    public int longestConsecutiveSequenceOptimal(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int longest = 1;
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hashSet.add(nums[i]);
        }

        for (int it : hashSet) {
            // If the hash contains it - 1, do not take the current value.
            // If it does not contain it - 1, then take the current value.
            if (!hashSet.contains(it - 1)) {
                int x = it;
                int count = 1;
                while (hashSet.contains(x + 1)) {
                    count++;
                    x++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence_1 solver = new LongestConsecutiveSequence_1();
        int[] nums = {102, 4, 100, 1, 101, 3, 2, 1, 1};

        int longestBrute = solver.longestConsecutiveSequenceBrute(nums);
        System.out.print("Longest Sequence Brute: ");
        System.out.println(longestBrute);

        int longestBetter = solver.longestConsecutiveSequenceBetter(nums.clone());
        System.out.print("Longest Sequence Better: ");
        System.out.println(longestBetter);

        int longestOptimal = solver.longestConsecutiveSequenceOptimal(nums.clone());
        System.out.print("Longest Sequence Optimal: ");
        System.out.println(longestOptimal);
    }
}
