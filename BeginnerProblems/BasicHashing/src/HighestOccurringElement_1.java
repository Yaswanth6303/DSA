import java.util.HashMap;
import java.util.Map;

public class HighestOccurringElement_1 {
    public int mostFrequentElementBrute(int[] nums) {
        int n = nums.length;

        int maxCount = 0;
        int maxFreqElement = -1;

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

            if (count > maxCount) {
                maxCount = count;
                maxFreqElement = nums[i];
            } else if (count == maxCount) {
                maxFreqElement = Math.min(maxFreqElement, nums[i]);
            }
        }

        return maxFreqElement;
    }
    public int mostFrequentElementOptimal(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> mpp = new HashMap<>();

        int maxFreqElement = -1;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCount) {
                maxCount = value;
                maxFreqElement = key;
            } else if (value == maxCount) {
                maxFreqElement = Math.min(key, maxFreqElement);
            }
        }

        return maxFreqElement;
    }
    public static void main(String[] args) {
        HighestOccurringElement_1 hoe = new HighestOccurringElement_1();
        int[] nums = {1, 2, 2, 3, 3, 3};
        System.out.println("Highest occurring element(Brute): " + hoe.mostFrequentElementBrute(nums));
        System.out.println("Highest occurring element(Optimal): " + hoe.mostFrequentElementOptimal(nums));
    }
}
