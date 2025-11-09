package constantWindow;

import java.util.Arrays;

public class LongestSubstringUniqueCharacters_2 {
    /**
     * Time Complexity: O(n^2) due to the nested for loops, where n is the length of the string.
     * The outer loop iterates n times, and the inner loop iterates up to n times in the worst case.
     * Also, Arrays.fill(hash, 0) takes O(256) which can be considered O(1).
     * Space Complexity: O(1) because the hash array has a fixed size of 256, independent of the input
     * string length. Thus, space used is constant.
     */
    public int longestNonRepeatingSubstringBrute(String str) {
        int n = str.length();
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];
            Arrays.fill(hash, 0);
            for (int j = i; j < n; j++) {
                if (hash[str.charAt(j)] == 1) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
                hash[str.charAt(j)] = 1;
            }
        }

        return maxLength;
    }
    static void main() {

    }
}
