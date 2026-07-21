package cycles03;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS_01 {

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int uNode = edge.get(0);
            int vNode = edge.get(1);
            adj.get(uNode).add(vNode);
        }

        int[] visited = new int[v];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, st);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;
    }

    public static void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        visited[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 0) {
                dfs(neighbor, visited, adj, st);
            }
        }

        st.push(node);
    }

    static void main(String[] args) {
        int v = 5;
        int e = 4;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(java.util.Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(2, 3)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(3, 4)));

        ArrayList<Integer> order = topologicalSort(edges, v, e);
        System.out.println("Topological Sort DFS: " + order);
    }
}