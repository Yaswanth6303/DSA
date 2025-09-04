import java.util.HashMap;

public class SumHighestLowestFrequency_3 {
    public int sumHighestAndLowestFrequencyBrute(int[] nums) {
        int n = nums.length;

        int maxFrequency = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            if (visited[i]) continue;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            maxFrequency = Math.max(maxFrequency, count);
            minFrequency = Math.min(minFrequency, count);
        }

        return maxFrequency + minFrequency;
    }

    public int sumHighestAndLowestFrequencyOptimal(int[] nums) {
        int n = nums.length;

        int maxFrequency = 0, minFrequency = n;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for (int freq : mpp.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
            minFrequency = Math.min(minFrequency, freq);
        }

        return maxFrequency + minFrequency;
    }

    public static void main(String[] args) {
        SumHighestLowestFrequency_3 shl = new SumHighestLowestFrequency_3();

        int[] nums = {1, 2, 2, 3, 3, 3};

        int resultBrute = shl.sumHighestAndLowestFrequencyBrute(nums);
        System.out.println("Sum of Highest and Lowest(Brute): " + resultBrute);

        int resultOptimal = shl.sumHighestAndLowestFrequencyOptimal(nums);
        System.out.println("Sum of Highest and Lowest(Optimal): " + resultOptimal);
    }
}
