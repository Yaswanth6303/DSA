package faqs;

import java.util.PriorityQueue;

public class MinimizeMaximumDistance_5 {
    public double getSectionLength(int start, int end, int stationsInBetween) {
        double distance = (double) (end - start) / (stationsInBetween + 1);
        return distance;
    }
    /**
     * Time Complexity: O(totalGasStations * n)
     * Space Complexity: O(n - 1)
     */
    public double minimiseMaxDistanceBrute(int[] positions, int totalGasStations) {
        int n = positions.length;
        int[] stationsPlaced = new int[n - 1];

        for (int gasStation = 1; gasStation <= totalGasStations; gasStation++) {
            double maximumSection = -1;
            int maximumIndex = -1;

            for (int i = 0; i < n - 1; i++) {
                double sectionLength = getSectionLength(positions[i], positions[i + 1], stationsPlaced[i]);

                if (sectionLength > maximumSection) {
                    maximumSection = sectionLength;
                    maximumIndex = i;
                }
            }
            stationsPlaced[maximumIndex]++;
        }

        double maximumDistance = -1;
        for (int i = 0; i < n - 1; i++) {
            double sectionLength = getSectionLength(positions[i], positions[i + 1], stationsPlaced[i]);
            maximumDistance = Math.max(maximumDistance, sectionLength);
        }

        return maximumDistance;
    }
    // Helper class to represent a section with its current max distance and index
    static class Section {
        double maxDistance;
        int index;

        Section(double maxDistance, int index) {
            this.maxDistance = maxDistance;
            this.index = index;
        }
    }
    /**
     * Time Complexity: O(n log n + totalGasStations log n)
     * Space Complexity: O(1)
     */
    public double minimiseMaxDistanceBetter(int[] positions, int totalGasStations) {
        int n = positions.length;
        int[] stationsPlaced = new int[n - 1];

        // Max heap to always get the section with the current largest segment
        PriorityQueue<Section> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.maxDistance, a.maxDistance)
        );

        // Initially add all segments
        for (int i = 0; i < n - 1; i++) {
            double distance = positions[i + 1] - positions[i];
            pq.offer(new Section(distance, i));
        }

        // Place gas stations
        for (int gasStation = 1; gasStation <= totalGasStations; gasStation++) {
            Section largest = pq.poll();  // Get the section with the largest distance
            int sectionIndex = largest.index;

            stationsPlaced[sectionIndex]++;

            double totalDistance = positions[sectionIndex + 1] - positions[sectionIndex];
            double newMaxDistance = totalDistance / (stationsPlaced[sectionIndex] + 1);

            pq.offer(new Section(newMaxDistance, sectionIndex));
        }

        return pq.peek().maxDistance;
    }
    private int getGasStationsRequired(double maxAllowedDistance, int[] positions) {
        int stationCount = 0;
        int n = positions.length;

        for (int i = 1; i < n; i++) {
            double segmentLength = positions[i] - positions[i - 1];
            int stationsNeeded = (int) (segmentLength / maxAllowedDistance);

            // If exactly divisible, one less station is needed
            if (segmentLength == stationsNeeded * maxAllowedDistance) {
                stationsNeeded--;
            }

            stationCount += stationsNeeded;
        }

        return stationCount;
    }
    /**
     * Time Complexity: O(n log(high-low))
     * Space Complexity: O(1)
     */
    public double minimiseMaxDistanceOptimal(int[] positions, int totalGasStationsToPlace) {
        int n = positions.length;
        double low = 0;
        double high = 0;

        // Find the maximum initial segment length
        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, positions[i + 1] - positions[i]);
        }

        double precision = 1e-6;

        while (high - low > precision) {
            double mid = (low + high) / 2.0;
            int requiredStations = getGasStationsRequired(mid, positions);

            if (requiredStations > totalGasStationsToPlace) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return high;
    }
    public static void main(String[] args) {
        MinimizeMaximumDistance_5 solver = new MinimizeMaximumDistance_5();
        int[] nums = {1, 13, 17, 23};
        int totalGasStations = 4;

        System.out.print("Maximum distance (Brute): ");
        double maximumDistanceBrute = solver.minimiseMaxDistanceBrute(nums, totalGasStations);
        System.out.println(maximumDistanceBrute);

        System.out.print("Maximum distance (Better): ");
        double maximumDistanceBetter = solver.minimiseMaxDistanceBetter(nums.clone(), totalGasStations);
        System.out.println(maximumDistanceBetter);

        System.out.print("Maximum distance (Optimal): ");
        double maximumDistanceOptimal = solver.minimiseMaxDistanceOptimal(nums.clone(), totalGasStations);
        System.out.println(maximumDistanceOptimal);
    }
}

/**
 * Try out these examples
 * 1) 1, 2, 3, 4, 5  totalGasStations = 4
 * 2) 1, 7 totalGasStations = 2
 */
