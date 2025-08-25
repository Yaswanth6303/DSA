package schedulingAndintervalProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsOneRoom_3 {
    // Schedules a maximum set of meetings and returns their original 1-based indices
    public static List<Integer> scheduleMeetings(int[] start, int[] end) {
        int n = start.length;
        List<int[]> meetings = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i], i + 1}); // {start, end, originalIndex}
        }

        // Sort by end time asc, then start time asc (stable choice for ties)
        meetings.sort((a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        List<Integer> picked = new ArrayList<>();
        int lastEnd = Integer.MIN_VALUE;

        for (int[] m : meetings) {
            // Strictly non-overlapping: allow m.start > lastEnd
            if (m[0] > lastEnd) {
                picked.add(m[2]);        // keep original index
                lastEnd = m[1];
            }
        }
        // Optional: keep result indices sorted by the time you *picked* them,
        // which is already chronological because we iterated by end-time.
        return picked;
    }

    // Convenience: return just the count
    public static int maxMeetings(int[] start, int[] end) {
        return scheduleMeetings(start, end).size();
    }

    // Demo
    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end   = {5, 4, 2, 9, 7, 9};

        List<Integer> selected = scheduleMeetings(start, end);
        System.out.println("Max meetings: " + maxMeetings(start, end));
        System.out.println("Pick meeting indices (1-based): " + selected);
        // Example output:
        // Max meetings: 4
        // Pick meeting indices (1-based): [3, 2, 5, 6]
    }
}
