package substringProblems;

public class NumberOfSubstrings_1 {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(3)
     */
    public int numberOfSubstringsBrute(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[3];
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'a']++;
                if (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(3)
     */
    public int numberOfSubstringsOptimal(String s) {
        int n = s.length();
        int[] lastSeen = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < n; i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(
                        Math.min(lastSeen[0], lastSeen[1]),
                        lastSeen[2]
                );
            }
        }
        return count;
    }

    static void main(String[] args) {
        NumberOfSubstrings_1 obj = new NumberOfSubstrings_1();
        String s = "bbacba";

        System.out.println("Brute Force Count: " + obj.numberOfSubstringsBrute(s));
        System.out.println("Optimal Count: " + obj.numberOfSubstringsOptimal(s));
    }
}
