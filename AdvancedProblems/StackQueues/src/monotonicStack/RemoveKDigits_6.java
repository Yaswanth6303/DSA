package monotonicStack;

import java.util.Stack;

public class RemoveKDigits_6 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String removeKDigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove remaining digits if k > 0
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.reverse();

        return sb.length() == 0 ? "0" : sb.toString();
    }

    static void main(String[] args) {
        RemoveKDigits_6 solution = new RemoveKDigits_6();
        String num = "1432219";
        int k = 3;
        String result = solution.removeKDigits(num, k);
        System.out.println("The smallest possible integer after removing k digits is: " + result);
    }
}
