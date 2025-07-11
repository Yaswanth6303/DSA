package faqHard;

public class MColoringProblemUsingArrays_4 { // Using Arrays
    // Function to check if it's safe to color the node
    public static boolean isSafe(int node, int[][] graph, int[] nodeColor, int n, int color) {
        for (int k = 0; k < n; k++) {
            // If node k is adjacent and has the same color
            if (graph[node][k] == 1 && nodeColor[k] == color) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function
    public static boolean solve(int node, int[][] graph, int[] nodeColor, int m, int n) {
        if (node == n) return true; // All nodes colored

        for (int color = 1; color <= m; color++) {
            if (isSafe(node, graph, nodeColor, n, color)) {
                nodeColor[node] = color;
                if (solve(node + 1, graph, nodeColor, m, n)) return true;
                nodeColor[node] = 0; // backtrack
            }
        }
        return false;
    }

    // Main function to check if graph can be colored with at most M colors
    public static boolean graphColoring(int[][] graph, int m, int n) {
        int[] nodeColor = new int[n];
        return solve(0, graph, nodeColor, m, n);
    }

    // Driver method to test the function
    public static void main(String[] args) {
        int n = 4; // nodes
        int m = 3; // colors
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}
        };

        // Initialize the adjacency matrix
        int[][] graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        if (graphColoring(graph, m, n)) {
            System.out.println("The graph can be colored with " + m + " colors.");
        } else {
            System.out.println("The graph cannot be colored with " + m + " colors.");
        }
    }
}
