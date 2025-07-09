package hard;

import java.util.*;

public class LetterCombinationMethod_2 {
    private final Map<Character, String> digitToChars;

    public LetterCombinationMethod_2() {
        digitToChars = new HashMap<>();
        digitToChars.put('2', "abc");
        digitToChars.put('3', "def");
        digitToChars.put('4', "ghi");
        digitToChars.put('5', "jkl");
        digitToChars.put('6', "mno");
        digitToChars.put('7', "pqrs");
        digitToChars.put('8', "tuv");
        digitToChars.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        backtrack(0, "", digits, result);
        return result;
    }

    private void backtrack(int index, String currentString, String digits, List<String> result) {
        if (index == digits.length()) {
            result.add(currentString);
            return;
        }

        String letters = digitToChars.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            backtrack(index + 1, currentString + letters.charAt(i), digits, result);
        }
    }
    public static void main(String[] args) {
        LetterCombinationMethod_2 solution = new LetterCombinationMethod_2();
        String digits = "23"; // Input digits
        List<String> result = solution.letterCombinations(digits); // Get combinations

        // Print the results
        System.out.println("All Combinations: ");
        for (String combination : result) {
            System.out.print(combination + " ");
        }
    }
}

