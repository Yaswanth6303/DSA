package longestandsmallestwindowproblems;

public class MinimumWindowSubstring_6 {
    public String minWindow(String s, String t) {
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
    static void main() {
        MinimumWindowSubstring_6 obj = new MinimumWindowSubstring_6();

        String s = "ddaaabbca";
        String t = "abc";
        String result = obj.minWindow(s, t);

        System.out.println("Minimum length substring containing all characters from \"" + t + "\" is: " + result);
    }
}
