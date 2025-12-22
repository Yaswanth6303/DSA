package longestandsmallestwindowproblems;

import java.util.HashMap;

public class KDistinctCharacters_4 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(k)
     */
    public int kDistinctCharactersBrute(String str, int k) {
        int n = str.length();
        int maxLength  = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> mpp = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = str.charAt(j);
                mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

                if (mpp.size() <= k) {
                    maxLength = Math.max(j - i + 1, maxLength);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }

    /**
     * Time Complexity: O(2n)
     * Space Complexity: O(k)
     */
    public int kDistinctCharactersBetter(String str, int k) {
        int n = str.length();

        int l = 0;
        int maxLength = 0;

        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char ch = str.charAt(r);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            while (mpp.size() > k) {
                char leftChar = str.charAt(l);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public int kDistinctCharactersOptimal(String str, int k) {
        int n = str.length();

        int l = 0;
        int maxLength = 0;

        HashMap<Character, Integer> mpp = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char ch = str.charAt(r);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            if (mpp.size() > k) {
                char leftChar = str.charAt(l);
                mpp.put(leftChar, mpp.get(leftChar) - 1);
                if (mpp.get(leftChar) == 0) {
                    mpp.remove(leftChar);
                }
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }

    static void main() {
        String str = "aaabbccd";
        int k = 2;

        KDistinctCharacters_4 obj = new KDistinctCharacters_4();
        int lengthBrute = obj.kDistinctCharactersBrute(str, k);
        System.out.println("Maximum length of substring with at most " + k + " distinct characters(Brute): " + lengthBrute);

        int lengthBetter = obj.kDistinctCharactersBetter(str, k);
        System.out.println("Maximum length of substring with at most " + k + " distinct characters(Better): " + lengthBetter);

        int lengthOptimal = obj.kDistinctCharactersOptimal(str, k);
        System.out.println("Maximum length of substring with at most " + k + " distinct characters(Optimal): " + lengthOptimal);
    }
}
