package leetcode.graphs;

import java.util.*;

public class Astronauts {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int numberOfAstronauts = scanner.nextInt();
        int pairs = scanner.nextInt();


        Map<Integer, ArrayList<Integer>> adjacenceyList = new HashMap<>();

        /**
         * 5 3
         * 0 1
         * 2 3
         * 0 4
         */
        for (int i = 0; i < pairs; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacenceyList.compute(u, (e,w) -> w == null ?  new ArrayList<Integer>() : w).add(v);
            adjacenceyList.compute(v, (e,w) -> w == null ?  new ArrayList<Integer>() : w).add(u);
        }


        boolean[] visited = new boolean[numberOfAstronauts];
        int ans = 0;
        for (int i = 0; i < numberOfAstronauts; i++) {
            adjacenceyList.computeIfAbsent(i, k -> new ArrayList<>());
            if (!visited[i]) {
                int vertices = 0;
                vertices = dfs(visited, adjacenceyList, vertices, i);
                ans = ans + vertices * (numberOfAstronauts - vertices);
            }
        }
        System.out.println(ans/2);
    }

    private static int dfs(boolean[] visited, Map<Integer, ArrayList<Integer>> adjacenceyList, int vertices, int starting) {
        visited[starting] = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(adjacenceyList.get(starting));

        while (!queue.isEmpty()) {
            List<Integer> connectedNodes = queue.poll();
            int size = connectedNodes.size();
            vertices++;
            for (int i = 0; i < size; i++) {
                if (!visited[connectedNodes.get(i)]) {
                    visited[connectedNodes.get(i)] = true;
                    queue.add(adjacenceyList.get(i));
                }
            }
        }
        return vertices;
    }
}
