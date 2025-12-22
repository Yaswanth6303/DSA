package longestandsmallestwindowproblems;

public class LongestRepeatingCharacter_5 {
    public int characterReplacementBrute(String str, int k) {
        int n = str.length();

        int maxLength = 0;
        int maxFrequency = 0;

        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            for (int j = i; j < n; j++) {
                int frequency = hash[str.charAt(j) - 'A']++;
                frequency++;

                maxFrequency = Math.max(maxFrequency, frequency);
                int strLength = j - i + 1;

                if ((strLength - maxFrequency) <= k) {
                    maxLength = Math.max(maxLength, strLength);
                } else {
                    break;
                }
            }
        }

        return maxLength;
    }

    public int characterReplacementBetter(String str, int k) {
        int n = str.length();

        int maxLength = 0;
        int maxFrequency = 0;

        int l = 0;

        int[] hash = new int[26];

        for (int r = 0; r < n; r++) {
            int frequency = hash[str.charAt(r) - 'A']++;
            frequency++;

            maxFrequency = Math.max(frequency, maxFrequency);
            int strLength = r - l + 1;

            while ((strLength - maxFrequency) > k) {
                hash[str.charAt(l) - 'A']--;
                l++;
                strLength = r - l + 1;

                maxFrequency = 0;
                for (int i = 0; i < 26; i++) {
                    maxFrequency = Math.max(maxFrequency, hash[i]);
                }

            }

            maxLength = Math.max(maxLength, strLength);
        }

        return maxLength;
    }

    public int characterReplacementOptimal(String str, int k) {
        int n = str.length();

        int l = 0;

        int maxFrequency = 0;
        int maxLength = 0;

        int[] hash = new int[26];

        for (int r = 0; r < n; r++) {
            int frequency = hash[str.charAt(r) - 'A']++;
            frequency++;

            maxFrequency = Math.max(frequency, maxFrequency);
            int strLength = r - l + 1;

            if ((strLength - maxFrequency) > k) {
                hash[str.charAt(l) - 'A']--;
                l++;
                strLength = r - l + 1;

                maxFrequency = 0;
                for (int i = 0; i < 26; i++) {
                    maxFrequency = Math.max(hash[i], maxFrequency);
                }

                maxLength = Math.max(maxLength, strLength);
            }
        }

        return maxLength;
    }

    static void main() {
        LongestRepeatingCharacter_5 obj = new LongestRepeatingCharacter_5();
        String str = "AABABBA";
        int k = 2;

        int lengthBrute = obj.characterReplacementBrute(str, k);
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + lengthBrute);

        int lengthBetter = obj.characterReplacementBetter(str, k);
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + lengthBetter);

        int lengthOptimal = obj.characterReplacementOptimal(str, k);
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + lengthOptimal);
    }
}
