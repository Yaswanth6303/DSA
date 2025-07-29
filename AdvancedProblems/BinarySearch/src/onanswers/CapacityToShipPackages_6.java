package onanswers;

public class CapacityToShipPackages_6 {
    public int[] findSumMax(int[] nums) {
        int n = nums.length;
        int maximum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maximum = Math.max(maximum, nums[i]);
        }

        return new int[]{sum, maximum};
    }

    public static int findDays(int[] weights, int shipCapacity) {
        int n = weights.length;
        int days = 1;
        int load = 0;

        for (int i = 0; i < n; i++) {
            if (load + weights[i] > shipCapacity) {
                days += 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }

        return days;
    }

    /**
     * Time Complexity = O(n) + O((sum - max + 1) * n) ≈ O(n^2) in the worst case
     * Space Complexity = O(1)
     */
    public int leastWeightCapacityBrute(int[] weights, int days) {
        int[] sumMax = findSumMax(weights);
        int sum = sumMax[0];
        int maximum = sumMax[1];

        for (int i = maximum; i <= sum; i++) {
            if (findDays(weights, i) <= days) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Time Complexity = O(n) + O(n * log(sum - max + 1)) ≈ O(n * log(sum))
     * Space Complexity = O(1)
     */
    public int leastWeightCapacityOptimal(int[] weights, int days) {
        int[] maxSum = findSumMax(weights);
        int sum = maxSum[0];
        int max = maxSum[1];

        int low = max;
        int high = sum;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (findDays(weights, mid) <= days) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        CapacityToShipPackages_6 solution = new CapacityToShipPackages_6();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;

        System.out.println(solution.leastWeightCapacityBrute(weights, days));
        System.out.println(solution.leastWeightCapacityOptimal(weights.clone(), days));
    }
}
