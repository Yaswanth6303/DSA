package longestandsmallestwindowproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitIntoBaskets_3 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(3)
     */
    public int totalFruitsBrute(int[] fruits) {
        int n = fruits.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(fruits[j]);
                if (set.size() > 2) break;
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
    /**
     * Time Complexity: O(2n)
     * Space Complexity: O(3) => Max Storing 3 elements in map
     */
    public int totalFruitsBetter(int[] fruits) {
        int n = fruits.length;
        int l = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int r = 0; r < n; r++) {
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

            if (mpp.size() > 2) {
                while (mpp.size() > 2) {
                    mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                    if (mpp.get(fruits[l]) == 0) {
                        mpp.remove(fruits[l]);
                    }
                    l++;
                }
            }

            if (mpp.size() < 2) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        return maxLength;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(3) => Max Storing 3 elements in map
     */
    public int totalFruitsOptimal(int[] fruits) {
        int n = fruits.length;
        int l = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int r = 0; r < n; r++) {
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);
            if (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }
                l++;
            }

            if (mpp.size() <= 2) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
        }
        return maxLength;
    }
    static void main() {
        int[] nums = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        FruitIntoBaskets_3 obj = new FruitIntoBaskets_3();        
        System.out.println("Maximum fruits in the basket is(Brute): " + obj.totalFruitsBrute(nums));
        System.out.println("Maximum fruits in the basket is(Better): " + obj.totalFruitsBetter(nums));
        System.out.println("Maximum fruits in the basket is(Optimal): " + obj.totalFruitsOptimal(nums));
    }
}
