package faqHard;

public class SudokuSolver_6 {

    public boolean solveSudoku(char[][] board) {
        return solve(board);
    }

    private boolean solve(char[][] board) {
        int n = 9;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Check for empty cell
                if (board[row][col] == '.') {
                    // Try placing digits 1-9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }
                    return false; // If no valid number found
                }
            }
        }
        return true; // Solved
    }

    // Check if placing num at board[row][col] is valid
    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == num) return false;
            // Check column
            if (board[i][col] == num) return false;
            // Check 3x3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == num) return false;
        }
        return true;
    }

    // Utility method to print the board
    public void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SudokuSolver_6 solver = new SudokuSolver_6();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Original Sudoku Puzzle:");
        solver.printBoard(board);

        if (solver.solveSudoku(board)) {
            System.out.println("\nSolved Sudoku Puzzle:");
            solver.printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
