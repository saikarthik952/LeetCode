package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleInUnDirected {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{0,1}, {1, 2}};
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            adj.compute(graph[i][0], (e,v) -> v == null ? new ArrayList<>() : v).add(graph[i][1]);
            adj.compute(graph[i][1], (e,v) -> v == null ? new ArrayList<>() : v).add(graph[i][0]);
        }
        boolean visited[] = new boolean[graph.length];


        for (int i = 0; i < graph.length; i++) {
            if (isCycle(visited, i, adj)) {
                System.out.println("Cycle exist ");
                break;
            }
        }

    }

    private static boolean isCycle(boolean[] visited, int i, Map<Integer, List<Integer>> adj) {
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        for (int v : adj.get(i)) {
            if (!visited[i])
            return isCycle(visited, v, adj);
        }
        return false;
    }
}
