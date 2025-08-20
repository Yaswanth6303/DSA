package schedulingAndintervalProblems;

import java.util.Arrays;

public class ShortestJobFirst_1 {
    public long solve(int[] bt) {
        int n = bt.length;
        Arrays.sort(bt);

        long waitingTime = 0;
        long totalTime = 0;

        for (int i = 0; i < n; i++) {
            waitingTime += totalTime;
            totalTime += bt[i];
        }

        return waitingTime / n;
    }
    public static void main(String[] args) {
        ShortestJobFirst_1 sjf = new ShortestJobFirst_1();
        int[] bt = {4, 3, 7, 1, 2};
        System.out.println("Average WT: " + sjf.solve(bt));
    }
}
