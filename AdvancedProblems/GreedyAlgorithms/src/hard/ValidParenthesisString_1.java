package hard;

public class ValidParenthesisString_1 {
    public boolean checkValid(int index, int count, String s) {
        // If closing bracket is more than opening
        if (count < 0) return false;

        // If we reached the end
        if (index == s.length()) {
            return count == 0;
        }

        char c = s.charAt(index);

        if (c == '(') {
            return checkValid(index + 1, count + 1, s);
        }
        else if (c == ')') {
            return checkValid(index + 1, count - 1, s);
        }
        else { // c == '*'
            // Choose 1: treat '*' as '('
            boolean asOpen = checkValid(index + 1, count + 1, s);

            // Choose 2: treat '*' as ')'
            boolean asClose = checkValid(index + 1, count - 1, s);

            // Choose 3: treat '*' as empty
            boolean asEmpty = checkValid(index + 1, count, s);

            return asOpen || asClose || asEmpty;
        }
    }

    public boolean isValidBrute(String s) {
        return checkValid(0, 0, s);
    }

    public boolean isValidOptimal(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) return false;
            if (minOpen < 0) minOpen = 0;
        }
        return minOpen == 0;
    }
    public static void main(String[] args) {
        String s = "(**()))";
        ValidParenthesisString_1 p = new ValidParenthesisString_1();
        System.out.println(p.isValidBrute(s));
        System.out.println(p.isValidOptimal(s));
    }
}
