package schedulingAndintervalProblems;

import java.util.Arrays;

public class MinimumNumberOfPlatforms_6 {
    public int findPlatformBrute(int[] arrival, int[] departure) {
        int n = arrival.length;

        int maxPlatforms = 1;
        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (arrival[i] >= arrival[j] && departure[j] >= arrival[i]) {
                        count++;
                    }
                }
            }

            maxPlatforms = Math.max(count, maxPlatforms);
        }

        return maxPlatforms;
    }
    public int findPlatformOptimal(int[] arrival, int[] departure) {
        int n = arrival.length;

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int maxPlatforms = 1;
        int count = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            maxPlatforms = Math.max(count, maxPlatforms);
        }

        return maxPlatforms;
    }
    public static void main(String[] args) {
        MinimumNumberOfPlatforms_6 mp = new MinimumNumberOfPlatforms_6();
        int[] arrival = {900, 945, 955, 1100, 1500, 1800};
        int[] departure = {920, 1200, 1130, 1150, 1900, 2000};

        System.out.println(mp.findPlatformBrute(arrival, departure));
        System.out.println(mp.findPlatformOptimal(arrival, departure));
    }
}
