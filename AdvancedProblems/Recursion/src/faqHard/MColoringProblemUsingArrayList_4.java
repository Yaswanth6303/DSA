package faqHard;

import java.util.ArrayList;
import java.util.List;

public class MColoringProblemUsingArrayList_4 {

    // Function to check if it's safe to color the node
    public static boolean isSafe(int node, List<List<Integer>> graph, List<Integer> nodeColor, int color) {
        for (int neighbor : graph.get(node)) {
            if (nodeColor.get(neighbor) == color) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function
    public static boolean solve(int node, List<List<Integer>> graph, List<Integer> nodeColor, int m, int n) {
        if (node == n) return true; // All nodes colored

        for (int color = 1; color <= m; color++) {
            if (isSafe(node, graph, nodeColor, color)) {
                nodeColor.set(node, color);
                if (solve(node + 1, graph, nodeColor, m, n)) return true;
                nodeColor.set(node, 0); // backtrack
            }
        }
        return false;
    }

    // Main function to check if graph can be colored with at most M colors
    public static boolean graphColoring(List<List<Integer>> graph, int m, int n) {
        List<Integer> nodeColor = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeColor.add(0); // initialize all with 0 (uncolored)
        }
        return solve(0, graph, nodeColor, m, n);
    }

    // Driver method to test the function
    public static void main(String[] args) {
        int n = 4; // nodes
        int m = 3; // colors
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}
        };

        // Initialize the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if (graphColoring(graph, m, n)) {
            System.out.println("The graph can be colored with " + m + " colors.");
        } else {
            System.out.println("The graph cannot be colored with " + m + " colors.");
        }
    }
}
