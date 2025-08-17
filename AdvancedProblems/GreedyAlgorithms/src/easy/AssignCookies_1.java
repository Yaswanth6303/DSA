package easy;

import java.util.Arrays;

public class AssignCookies_1 {
    /**
     * Time Complexity: O(n log n + m log m + m)
     * Space Complexity: O(1)
     */
    public int findMaximumCookieStudents(int[] students, int[] cookies) {
        int s = students.length;
        int c = cookies.length;

        Arrays.sort(students);
        Arrays.sort(cookies);

        int i = 0;
        int j = 0;

        while (i < s && j < c) {
            if (students[i] <= cookies[j]) {
                i++;
            }
            j++;
        }

        return i;
    }
    public static void main(String[] args) {
        int[] students = {1, 5, 3, 3, 4};
        int[] cookies = {4, 2, 1, 2, 1, 3};

    }
}
