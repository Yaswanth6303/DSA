package twoDArrays;

public class MaximumOnes_1 {
    public int rowWithMax1sBrute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxCount = 0;
        int rowIndex = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                rowIndex = i;
            }
        }

        return rowIndex;
    }
    public int rowWithMax1sOptimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxOnes = 0;
        int rowIndex = -1;

        for (int i = 0; i < n; i++) {
            int index = firstOneIndex(matrix[i]);
            if (index != -1) {
                int onesCount = m - index;
                if (onesCount > maxOnes) {
                    maxOnes = onesCount;
                    rowIndex = i;
                }
            }
        }

        return rowIndex;
    }

    private int firstOneIndex(int[] row) {
        int low = 0, high = row.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == 1) {
                result = mid; // Potential first 1
                high = mid - 1; // Try to find earlier one
            } else {
                low = mid + 1;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        MaximumOnes_1 solution = new MaximumOnes_1();

        int[][] matrix = {
                {0, 0, 0, 1},
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };

        int resultBrute = solution.rowWithMax1sBrute(matrix);
        System.out.println("Row index with maximum 1s (Brute): " + resultBrute);

        int resultOptimal = solution.rowWithMax1sOptimal(matrix);
        System.out.println("Row index with maximum 1s (Optimal): " + resultOptimal);
    }
}
