package implementationProblems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis_2 {
    /**
     * Time Complexity: O(2^2N / sqrt(n)) = O(4^n / sqrt(n))
     * Space Complexity: O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }
    public void generate(int open, int close, int n, String currentString, List<String> result) {
        if (open > n) return;
        if (open == close && open + close == 2 * n) {
            result.add(currentString);
            return;
        }

        if (open < n) {
            generate(open + 1, close, n, currentString + '(', result);
        }

        if (close < open) {
            generate(open, close + 1, n, currentString + ')', result);
        }
    }
    public static void main(String[] args) {
        GenerateParenthesis_2 solution = new GenerateParenthesis_2();
        int n = 3;
        List<String> result = solution.generateParenthesis(n);

        System.out.println("All combinations of balanced parentheses for n = " + n + " are:");
        for (String combination : result) {
            System.out.println(combination);
        }
    }
}
