package theoryandtraversals01;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS_01 {
    public static void dfs(int node, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        current.add(node);

        for(int neighbour : adj.get(node)) {
            if(visited[neighbour] == 0) {
                dfs(neighbour, current, adj, visited);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for(ArrayList<Integer> edge : edges) {
            int uNode = edge.get(0);
            int vNode = edge.get(1);

            adj.get(uNode).add(vNode);
            adj.get(vNode).add(uNode);
        }

        int[] visited = new int[v];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            if(visited[i] == 0) {
                ArrayList<Integer> current = new ArrayList<>();
                dfs(i, current, adj, visited);
                result.add(current);
            }
        }

        return result;
    }

    static void main(String[] args) {
        int v = 5;
        int e = 4;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4)));

        ArrayList<ArrayList<Integer>> result = depthFirstSearch(v, e, edges);

        System.out.println("DFS Traversal Output: " + result);
    }
}