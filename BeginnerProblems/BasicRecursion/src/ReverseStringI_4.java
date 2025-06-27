import java.util.ArrayList;

public class ReverseStringI_4 {
    public void reverse(ArrayList<Character> ch, int left, int right) {
        if (left >= right) return;

        char temp = ch.get(left);
        ch.set(left, ch.get(right));
        ch.set(right, temp);
        reverse(ch, left + 1, right - 1);
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public ArrayList<Character> reverseString(ArrayList<Character> ch) {
        int left = 0;
        int right = ch.size() - 1;
        reverse(ch, left, right);
        return ch;
    }
    public static void main(String[] args) {
        ReverseStringI_4 solution = new ReverseStringI_4();
        ArrayList<Character> ch = new ArrayList<>();
        ch.add('h');
        ch.add('e');
        ch.add('l');
        ch.add('l');
        ch.add('o');

        ArrayList<Character> reversed = solution.reverseString(ch);
        System.out.println("Reversed String: " + reversed);
    }
}
