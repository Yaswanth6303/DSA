package faqMedium;

public class SetMatrixZeros_14 {

    // Utility method to print the matrix
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Brute Force Approach
     * ---------------------
     * Time Complexity: O(n * m) * O(n + m) + O(n * m)
     *   - First pass: O(n * m)
     *   - For every 0: markRow → O(m), markColumn → O(n) → total worst case: O(n + m)
     *   - Second pass to convert -1 to 0: O(n * m)
     *
     * Space Complexity: O(1) — No extra space used
     */
    public void setZerosBrute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markColumn(matrix, j);
                }
            }
        }

        // Convert marked cells (-1) to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Marks the given row with -1 if the cell is not already 0
    public static void markRow(int[][] matrix, int rowNumber) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[rowNumber][j] != 0) {
                matrix[rowNumber][j] = -1;
            }
        }
    }

    // Marks the given column with -1 if the cell is not already 0
    public static void markColumn(int[][] matrix, int columnNumber) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][columnNumber] != 0) {
                matrix[i][columnNumber] = -1;
            }
        }
    }

    /**
     * Better Approach
     * ----------------
     * Time Complexity: O(2 * n * m)
     *   - First pass: O(n * m) → to find 0s and store in boolean arrays
     *   - Second pass: O(n * m) → to set corresponding rows and columns to 0
     *
     * Space Complexity: O(n) + O(m) → for row and column marker arrays
     */
    public void setZerosBetter(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        // Mark rows and columns that contain 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Update the matrix using the row and column markers
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Optimal Approach
     * -----------------
     * Time Complexity: O(2 * n * m)
     *   - First pass: O(n * m) → to mark first row & column
     *   - Second pass: O(n * m) → to apply 0s based on markers
     *
     * Space Complexity: O(1) → uses the matrix itself as marker
     */
    public void setZerosOptimal(int[][] matrix) {
        // Column = matrix[0][..]
        // Row = matrix[..][0]

        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;

        // First pass: use first row and first column as markers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0; // First column must be zeroed
                    }
                }
            }
        }

        // Second pass: update the cells except first row and column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // Check for Column and Row
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero the first row if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Zero the first column if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros_14 solver = new SetMatrixZeros_14();

        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Create deep copies of original matrix for each method
        int[][] matrix2 = new int[matrix.length][];
        int[][] matrix3 = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrix2[i] = matrix[i].clone();
            matrix3[i] = matrix[i].clone();
        }

        solver.setZerosBrute(matrix);
        System.out.println("Matrix after setting zeroes (Brute):");
        printMatrix(matrix);

        solver.setZerosBetter(matrix2);
        System.out.println("Matrix after setting zeroes (Better):");
        printMatrix(matrix2);

        solver.setZerosOptimal(matrix3);
        System.out.println("Matrix after setting zeroes (Optimal):");
        printMatrix(matrix3);
    }
}
