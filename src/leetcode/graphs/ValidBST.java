package leetcode.graphs;

import java.util.*;

public class ValidBST {

    public static void main(String[] args) {
        int size = 4;
        int[][] graph = new int[][]{{1,2},{1,3},{2,4}};
        int[] sequence = new int[]{1,2,4,3};
        int[] index = new int[size + 1];
        boolean[] visited = new boolean[size + 1];

        for (int i = 0; i < size; i++) {
            index[sequence[i]] = i;
        }


        Arrays.sort(graph,  (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if ( index[o1[1]] < index[o2[1]])
                    return -1;
            }
            return 1;
        });

        ArrayList<Integer>[] graph1 = new ArrayList[size + 1];

        for (int[] d : graph) {
            if (graph1[d[0]] == null) {
                graph1[d[0]] = new ArrayList<>();
            }
            if (graph1[d[1]] == null) {
                graph1[d[1]] = new ArrayList<>();
            }
           graph1[d[0]].add(d[1]);
            graph1[d[1]].add(d[0]);


        }
        for (Integer bf : bfs(graph1, visited, index)) {
            System.out.println(bf);
        }


    }

    private static List<Integer> bfs(ArrayList<Integer>[] graph, boolean[] visited, int[] indez) {
        final Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;
        List<Integer> integerList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int front = queue.poll();
            integerList.add(front);
            for (int data : graph[front]) {
                if (!visited[data]) {
                    visited[data] = true;
                    queue.add(data);
                }
            }

        }
        return integerList;
    }
}
