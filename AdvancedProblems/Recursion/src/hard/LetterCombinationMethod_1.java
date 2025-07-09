package hard;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationMethod_1 {
    // Using Arrays
    private final String[] map;
    public LetterCombinationMethod_1() {
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        backtrack(0, "", digits, result);
        return result;
    }

    public void backtrack(int index, String currentString, String digits, List<String> result) {
        if (index == digits.length()) {
            result.add(currentString);
            return;
        }

        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            backtrack(index + 1, currentString + s.charAt(i), digits, result);
        }
    }
    public static void main(String[] args) {
        LetterCombinationMethod_1 solution = new LetterCombinationMethod_1();
        String digits = "23"; // Input digits
        List<String> result = solution.letterCombinations(digits); // Get combinations

        // Print the results
        System.out.println("All Combinations: ");
        for (String combination : result) {
            System.out.print(combination + " ");
        }
    }
}
