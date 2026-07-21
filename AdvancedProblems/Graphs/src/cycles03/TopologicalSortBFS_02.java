package cycles03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS_02 {

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

        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return result;
    }

    static void main(String[] args) {
        int v = 5;
        int e = 4;

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(java.util.Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(1, 3)));
        edges.add(new ArrayList<>(java.util.Arrays.asList(2, 4)));

        ArrayList<Integer> result = topologicalSort(edges, v, e);
        System.out.println(result);
    }
}