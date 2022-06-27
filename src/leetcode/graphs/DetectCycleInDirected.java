package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleInDirected {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{0,1},{0,2},{1,2},{2,0},{2,3},{3,3}};
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            adj.compute(graph[i][0], (e,v) -> v == null ? new ArrayList<>() : v).add(graph[i][1]);
        }
        boolean visited[] = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];


        for (int i = 0; i < graph.length; i++) {
            if (isCycle(visited, stack, i, adj)) {
                System.out.println("Cycle exist ");
                break;
            }
        }

    }

    private static boolean isCycle(boolean[] visited, boolean[] stack, int i, Map<Integer, List<Integer>> adj) {


    if (stack[i]) {
        return true;
    }

    if (visited[i]) {
        return false;
    }

    visited[i] = true;
    stack[i] = true;
    for (int v : adj.get(i)) {
        return isCycle(visited, stack, v, adj);
    }
    visited[i] = false;
    return false;
    }
}
