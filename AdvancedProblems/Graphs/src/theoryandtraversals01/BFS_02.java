package theoryandtraversals01;

import java.util.*;

public class BFS_02 {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> bfsTraversal = new ArrayList<>();
        int[] visited = new int[n];

        q.add(0);
        visited[0] = 1;

        while(!q.isEmpty()) {
            int node = q.poll();
            bfsTraversal.add(node);

            for(int neighbour : adj.get(node)) {
                if(visited[neighbour] == 0) {
                    q.add(neighbour);
                    visited[neighbour] = 1;
                }
            }
        }

        return bfsTraversal;
    }

    static void main(String[] args) {
        int n = 5;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 0, 1);
        addEdge(adj, 2, 4);

        List<Integer> result = bfsTraversal(n, adj);

        System.out.println("BFS Traversal Order: " + result);
    }

    private static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
