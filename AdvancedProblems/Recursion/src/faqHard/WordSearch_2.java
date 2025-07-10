package faqHard;

public class WordSearch_2 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Try to start from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col) {
        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Check bounds and current cell character
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
                board[row][col] != word.charAt(index) || board[row][col] == '#') {
            return false;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#'; // Use a placeholder

        // Explore all 4 directions
        boolean found = backtrack(board, word, index + 1, row + 1, col) ||
                backtrack(board, word, index + 1, row - 1, col) ||
                backtrack(board, word, index + 1, row, col + 1) ||
                backtrack(board, word, index + 1, row, col - 1);

        // Restore the original character (backtrack)
        board[row][col] = temp;

        return found;
    }

    public static void main(String[] args) {
        WordSearch_2 ws = new WordSearch_2();

        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        System.out.println(ws.exist(board, word1));
        System.out.println(ws.exist(board, word2));
        System.out.println(ws.exist(board, word3));
    }
}
