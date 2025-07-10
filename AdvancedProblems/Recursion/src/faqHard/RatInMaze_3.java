package faqHard;

import java.util.*;

public class RatInMaze_3 {
    // List to store all valid paths
    List<String> allPaths;

    public RatInMaze_3() {
        allPaths = new ArrayList<>();
    }

    // Recursive function to explore all possible paths
    private void explorePaths(int[][] maze, int row, int col, String currentPath, int size) {
        // If destination (bottom-right) is reached, add path to list
        if (row == size - 1 && col == size - 1) {
            allPaths.add(currentPath);
            return;
        }

        // Mark current cell as visited
        maze[row][col] = 0;

        // Try moving Up
        if (row - 1 >= 0 && maze[row - 1][col] == 1) {
            explorePaths(maze, row - 1, col, currentPath + 'U', size);
        }

        // Try moving Left
        if (col - 1 >= 0 && maze[row][col - 1] == 1) {
            explorePaths(maze, row, col - 1, currentPath + 'L', size);
        }

        // Try moving Down
        if (row + 1 < size && maze[row + 1][col] == 1) {
            explorePaths(maze, row + 1, col, currentPath + 'D', size);
        }

        // Try moving Right
        if (col + 1 < size && maze[row][col + 1] == 1) {
            explorePaths(maze, row, col + 1, currentPath + 'R', size);
        }

        // Backtrack: Unmark the current cell
        maze[row][col] = 1;
    }

    // Main function to find all paths from (0, 0) to (n-1, n-1)
    public List<String> findPathsInMaze(int[][] maze) {
        int size = maze.length;

        allPaths.clear();

        // If starting or ending cell is blocked, no path is possible
        if (maze[0][0] == 0 || maze[size - 1][size - 1] == 0) {
            return allPaths;
        }

        // Start exploring from (0, 0)
        explorePaths(maze, 0, 0, "", size);

        // Sort paths lexicographically
        Collections.sort(allPaths);

        return allPaths;
    }

    public static void main(String[] args) {
        RatInMaze_3 solver = new RatInMaze_3();

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1},
        };

        List<String> resultPaths = solver.findPathsInMaze(maze);

        if (resultPaths.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Paths from start to destination:");
            for (String path : resultPaths) {
                System.out.println(path);
            }
        }
    }
}
