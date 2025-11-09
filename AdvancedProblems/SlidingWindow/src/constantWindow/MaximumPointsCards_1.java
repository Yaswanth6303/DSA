package constantWindow;

public class MaximumPointsCards_1 {
    /**
     * TC: O(2 * K)
     * SC: O(1)
     */
    public int maxScore(int[] cardScores, int k) {
        int n = cardScores.length;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            sum += cardScores[i];
        }
        maxSum = Math.max(sum, maxSum);

        int leftSum = k - 1;
        int rightSum = n - 1;
        while (leftSum >= 0) {
            sum -= cardScores[leftSum];
            sum += cardScores[rightSum];
            maxSum = Math.max(sum, maxSum);
            leftSum--;
            rightSum--;
        }

        return maxSum;
    }
    static void main() {
        MaximumPointsCards_1 mpc = new MaximumPointsCards_1();
        int[] cardScores = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        int k = 4;
        int result = mpc.maxScore(cardScores, k);
        System.out.println("The maximum score is: " + result);
    }
}
