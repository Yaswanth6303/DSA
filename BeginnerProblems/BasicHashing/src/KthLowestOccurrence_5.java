import java.util.*;

public class KthLowestOccurrence_5 {
    // Brute Force
    public int findKthLowestOccurringBrute(int[] nums, int k) {
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

        // Step 3: Sort by frequency (ascending now)
        Collections.sort(freqList, (a, b) -> a[1] - b[1]);

        // Step 4: Pick K-th element
        if (k <= 0 || k > freqList.size()) {
            throw new IllegalArgumentException("Invalid K: " + k);
        }

        return freqList.get(k - 1)[0];
    }

    // Optimal using HashMap
    public int findKthLowestOccurringOptimal(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // Convert map to list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());

        // Sort by frequency ascending
        list.sort((a, b) -> a.getValue().compareTo(b.getValue()));

        if (k <= 0 || k > list.size()) {
            throw new IllegalArgumentException("Invalid K: " + k);
        }

        return list.get(k - 1).getKey();
    }

    public static void main(String[] args) {
        KthLowestOccurrence_5 kto = new KthLowestOccurrence_5();
        int[] nums = {1, 3, 2, 1, 4, 1, 3, 2, 2, 2, 5};
        int k = 2;

        int resultBrute = kto.findKthLowestOccurringBrute(nums, k);
        System.out.println(k + "-th lowest occurring element (Brute): " + resultBrute);

        int resultOptimal = kto.findKthLowestOccurringOptimal(nums, k);
        System.out.println(k + "-th lowest occurring element (Optimal): " + resultOptimal);
    }
}
