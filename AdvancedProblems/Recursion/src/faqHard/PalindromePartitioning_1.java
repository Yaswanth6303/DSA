package faqHard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_1 {
    /**
     * Time Complexity:O(N*2^N) where N is the length of the string, due to the exponential number
     * of possible partitions and the linear time to check each partition.
     * Space Complexity:O(N) due to the maximum depth of the recursion stack and the space used
     * by the currentList which stores at most N substrings.
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentList = new ArrayList<>();
        backtrack(0, s, currentList, result);
        return result;
    }

    public void backtrack(int index, String s, List<String> currentList, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                currentList.add(s.substring(index, i + 1));
                backtrack(i + 1, s, currentList, result);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning_1 solution = new PalindromePartitioning_1();
        String s = "aab";
        List<List<String>> result = solution.partition(s);
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
