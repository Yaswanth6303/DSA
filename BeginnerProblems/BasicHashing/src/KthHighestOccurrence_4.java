import java.util.*;

public class KthHighestOccurrence_4 {
    public int findKthHighestOccurringBrute(int[] nums, int k) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        List<int[]> freqList = new ArrayList<>(); // [element, frequency]

        // Step 1 & 2: Count frequencies manually
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            freqList.add(new int[]{nums[i], count});
        }

        // Step 3: Sort by frequency (descending)
        Collections.sort(freqList, (a, b) -> b[1] - a[1]);

        // Step 4: Pick K-th element
        if (k <= 0 || k > freqList.size()) {
            throw new IllegalArgumentException("Invalid K: " + k);
        }

        return freqList.get(k - 1)[0];
    }

    public int findKthHighestOccurringOptimal(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        if (k <= 0 || k > list.size()) {
            throw new IllegalArgumentException("Invalid K: " + k);
        }

        return list.get(k - 1).getKey();
    }

    public static void main(String[] args) {
        KthHighestOccurrence_4 kto = new KthHighestOccurrence_4();
        int[] nums = {1, 3, 2, 1, 4, 1, 3, 2, 2, 2, 5};
        int k = 2;

        int resultBrute = kto.findKthHighestOccurringBrute(nums, k);
        System.out.println(k + "-th highest occurring element (Brute): " + resultBrute);

        int resultOptimal = kto.findKthHighestOccurringOptimal(nums, k);
        System.out.println(k + "-th highest occurring element (Optimal): " + resultOptimal);
    }
}
