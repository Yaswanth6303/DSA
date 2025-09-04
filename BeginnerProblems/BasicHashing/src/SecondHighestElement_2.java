import java.util.HashMap;
import java.util.Map;

public class SecondHighestElement_2 {
    public int secondMostFrequentElementBrute(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        int firstMaxElement = -1;
        int secondMaxElement = -1;

        int maxCount = 0;
        int secMaxCount = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            if (count > maxCount) {
                secMaxCount = maxCount;
                secondMaxElement = firstMaxElement;

                maxCount = count;
                firstMaxElement = nums[i];
            } else if (count == maxCount) {
                if (nums[i] < firstMaxElement) {
                    secondMaxElement = firstMaxElement;
                    secMaxCount = maxCount;

                    firstMaxElement = nums[i];
                }
            } else if (count > secMaxCount) {
                secMaxCount = count;
                secondMaxElement = nums[i];
            } else if (count == secMaxCount) {
                secondMaxElement = Math.min(secondMaxElement, nums[i]);
            }
        }

        return secondMaxElement;
    }

    public int secondMostFrequentElementOptimal(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0, secondMaxFreq = 0;
        int maxElement = -1, secondMaxElement = -1;

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFreq) {
                secondMaxFreq = maxFreq;
                secondMaxElement = maxElement;

                maxFreq = frequency;
                maxElement = element;
            } else if (frequency == maxFreq) {
                if (element < maxElement) {
                    secondMaxFreq = maxFreq;
                    secondMaxElement = maxElement;

                    maxElement = element;
                }
            } else if (frequency > secondMaxFreq) {
                secondMaxFreq = frequency;
                secondMaxElement = element;
            } else if (frequency == secondMaxFreq) {
                secondMaxElement = Math.min(secondMaxElement, element);
            }
        }

        return secondMaxElement;
    }

    public static void main(String[] args) {
        SecondHighestElement_2 she = new SecondHighestElement_2();

        int[] nums = {1, 2, 2, 3, 3, 3};

        System.out.println("Second Highest Element (Brute): " + she.secondMostFrequentElementBrute(nums));
        System.out.println("Second Highest Element (Optimal): " + she.secondMostFrequentElementOptimal(nums));
    }
}
