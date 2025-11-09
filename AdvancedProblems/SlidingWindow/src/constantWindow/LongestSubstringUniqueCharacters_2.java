package constantWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * Time Complexity:O(n) because the code iterates through the string once using a for loop, and
     * HashMap operations take O(1) time on average.
     * Space Complexity:O(n) in the worst case because the HashMap `mpp` can store up to n characters
     * from the string.
     *
     */
    public int longestNonRepeatingSubstringBetter(String str) {
        int n = str.length();
        int maxLength = 0;
        int l = 0;
        Map<Character, Integer> mpp = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char ch = str.charAt(r);
            if (mpp.containsKey(ch)) {
                // Move left pointer just after the last occurrence of the current character
                l = Math.max(l, mpp.get(ch) + 1);
            }

            // Update the last index of the current character
            mpp.put(ch, r);

            // Calculate max length of current valid window
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }

    /**
     * Time Complexity:O(n) because the code iterates through the string of length n once, with a
     * constant time operation inside the loop.
     * Space Complexity:O(1) because the code uses a fixed-size array of 256 integers, regardless of
     * the input string size, hence constant space.
     */
    public int longestNonRepeatingSubstringOptimal(String str) {
        int n = str.length();
        int[] lastIndex = new int[256]; // stores last seen index of each character
        Arrays.fill(lastIndex, -1);     // initialize all to -1

        int maxLength = 0;
        int l = 0; // left pointer

        for (int r = 0; r < n; r++) {
            char ch = str.charAt(r);

            // If character was seen before, move left pointer
            if (lastIndex[ch] != -1) {
                l = Math.max(l, lastIndex[ch] + 1);
            }

            // Update last index of this character
            lastIndex[ch] = r;

            // Update max length of valid window
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
    static void main() {
        LongestSubstringUniqueCharacters_2 sol = new LongestSubstringUniqueCharacters_2();
        String str = "abcddabac";
        System.out.println("Longest Substring (Brute): " + sol.longestNonRepeatingSubstringBrute(str));
        System.out.println("Longest Substring (Better): " + sol.longestNonRepeatingSubstringBetter(str));
        System.out.println("Longest Substring (Optimal): " + sol.longestNonRepeatingSubstringOptimal(str));
    }
}
