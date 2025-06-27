public class StringPalindrome_5 {
    public boolean palindromeCheck(String s) {
        return isPalindrome(s, 0, s.length() - 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }

    // Main method to test the palindromeCheck function
    public static void main(String[] args) {
        StringPalindrome_5 solution = new StringPalindrome_5();
        System.out.println(solution.palindromeCheck("hannah"));
        System.out.println(solution.palindromeCheck("aabbaaa"));
        System.out.println(solution.palindromeCheck("aba"));
    }
}
