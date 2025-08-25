package schedulingAndintervalProblems;

import java.util.Arrays;

public class NonOverlappingIntervals_4 {
    public int maxIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
    public static void main(String[] args) {
        NonOverlappingIntervals_4 mI = new NonOverlappingIntervals_4();
        int[][] intervals = {{0, 5}, {3, 4}, {1, 2}, {5, 9}, {7, 9}};
        System.out.println("Min removals: " + mI.maxIntervals(intervals));
    }
}
