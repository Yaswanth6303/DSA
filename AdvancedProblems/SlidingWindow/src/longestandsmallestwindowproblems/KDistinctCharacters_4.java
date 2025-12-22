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
    static void main() {
        String str = "aaabbccd";
        int k = 2;
        KDistinctCharacters_4 objBrute = new KDistinctCharacters_4();
        int lengthBrute = objBrute.kDistinctCharactersBrute(str, k);
        System.out.println("Maximum length of substring with at most " + k + " distinct characters: " + lengthBrute);
    }
}
