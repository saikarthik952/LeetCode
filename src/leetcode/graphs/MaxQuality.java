package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxQuality {
    static int answer = 0;
    public static void main(String[] args) {
        MT mt = new MT();
        Thread a = new Thread(mt);
        /**
         * values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49
         */
        int[] values = new int[]{0,32,10,43};
        int[][] edges = new int[][]
                {
                        {0,1,10},
                        {1,2,15},
                        {0,3,10}
                };
        int maxTime = 49;

        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int t = edges[i][2];

            adj.compute(u, (e,w) -> w == null ?  new ArrayList<Integer[]>() : w).add(new Integer[]{v,t});
            adj.compute(v, (e,w) -> w == null ?  new ArrayList<Integer[]>() : w).add(new Integer[]{u,t});
        }
        int[] visited = new int[edges.length + 1];
        int max = 0;
        dfs(adj, maxTime, 0, values, 0, visited, 0);
        System.out.println(answer);

    }

    private static void dfs(Map<Integer, ArrayList<Integer[]>> adj, int maxTime, int time, int[] values, int starting, int[] visited, int currentSum) {


        if (time > maxTime) {
            return;
        }

        if (visited[starting] == 0) {
            currentSum += values[starting];
        }

        visited[starting]++;

        if (starting == 0) {
            answer = Math.max(currentSum, answer);
        }

        for (Integer[] integers : adj.get(starting)) {
                dfs(adj, maxTime, time + integers[1], values, integers[0], visited, currentSum);
        }
        visited[starting]--;
    }
}
