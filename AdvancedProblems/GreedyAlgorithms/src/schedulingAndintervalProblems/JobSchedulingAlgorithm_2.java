package schedulingAndintervalProblems;

import java.util.Arrays;
import java.util.TreeMap;

public class JobSchedulingAlgorithm_2 {
    public int[] jobScheduling(int[][] jobs) {
        // jobs[i] = {id, deadline, profit}

        int n = jobs.length;

        // Find maximum deadline
        int maxDeadline = 0;
        for (int[] job : jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }

        // TreeMap stores available days (1 ... maxDeadline)
        TreeMap<Integer, Boolean> availableDays = new TreeMap<>();
        for (int d = 1; d <= maxDeadline; d++) {
            availableDays.put(d, true);
        }

        // Sort jobs by profit (descending)
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);

        int totalProfit = 0, countJobs = 0;

        for (int[] job : jobs) {
            int deadline = job[1];
            int profit = job[2];

            // Find the latest available day <= deadline
            Integer day = availableDays.floorKey(deadline);

            if (day != null) {
                // Assign this job
                totalProfit += profit;
                countJobs++;
                availableDays.remove(day); // Mark this day as filled
            }
        }

        return new int[] {countJobs, totalProfit};
    }
    public static void main(String[] args) {
        JobSchedulingAlgorithm_2 jsa = new JobSchedulingAlgorithm_2();
        int[][] jobs = {{1, 4, 40}, {2, 1, 10}, {3, 1, 40}, {4, 1, 30}};
        int[] result = jsa.jobScheduling(jobs);

        System.out.println("Number of Jobs: " + result[0]);
        System.out.println("Maximum Profit: " + result[1]);
    }
}
