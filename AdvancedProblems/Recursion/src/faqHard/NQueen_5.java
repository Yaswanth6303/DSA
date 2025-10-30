package faqHard;

import java.util.*;

public class NQueen_5 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, n, board, solutions);
        return solutions;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> solutions) {
        if (row == n) {
            solutions.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';  // Place queen
                backtrack(row + 1, n, board, solutions);  // Move to next row
                board[row][col] = '.';  // Backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        int r, c;

        // Check column (above current row)
        r = row - 1;
        while (r >= 0) {
            if (board[r][col] == 'Q') {
                return false;
            }
            r--;
        }

        // Check upper-left diagonal
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // Check upper-right diagonal
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        NQueen_5 solver = new NQueen_5();
        int n = 4; // You can change this value
        List<List<String>> solutions = solver.solveNQueens(n);

        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
