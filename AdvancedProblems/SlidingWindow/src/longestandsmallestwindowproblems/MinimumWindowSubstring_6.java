package longestandsmallestwindowproblems;

public class MinimumWindowSubstring_6 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(256)
     */
    public String minWindowBrute(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < sLength; i++) {
            int[] hash = new int[256];
            for (char ch : t.toCharArray()) {
                hash[ch]++;
            }

            int count = 0;
            for (int j = i; j < sLength; j++) {
                if (hash[s.charAt(j)] > 0) {
                    count++;
                }
                hash[s.charAt(j)]--;

                if (count == tLength) {
                    int strLength = j - i + 1;
                    if (strLength < minLength) {
                        minLength = strLength;
                        startIndex = i;
                    }
                    break;
                }
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLength);
    }
    /**
     * Time Complexity: O(2n + m)
     * Space Complexity: O(256)
     */
    public String minWindowOptimal(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;

        int[] hash = new int[256];
        for (char ch : t.toCharArray()) {
            hash[ch]++;
        }

        int l = 0;
        int count = 0;

        for (int r = 0; r < sLen; r++) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;

            while (count == tLen) {
                int strLength = r - l + 1;
                if (strLength < minLength) {
                    minLength = strLength;
                    startIndex = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
        }
        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLength);

    }

    static void main() {
        MinimumWindowSubstring_6 obj = new MinimumWindowSubstring_6();

        String s = "ddaaabbca";
        String t = "abc";

        String resultBrute = obj.minWindowBrute(s, t);
        System.out.println("Minimum length substring containing all characters from \"" + t + "\" is(Brute): " + resultBrute);

        String resultOptimal = obj.minWindowOptimal(s, t);
        System.out.println("Minimum length substring containing all characters from \"" + t + "\" is(Optimal): " + resultOptimal);
    }
}
