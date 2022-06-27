package leetcode.six;

public class Province {
    /**
     * Typical Depth first search, where we are keeping a visited to check what all nodes can be discoverd via the edges that we have, and the
     * answer here is number of non connected nodes in the graph.
     * @param args
     */
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1,1,0},{1,1,0},{0,0,1}};

        int[][] arr = new int[][]{{1,0,0},{0,1,0},{0,0,1}};

        int count = 0;

        boolean[] visited = new boolean[arr.length];


            for(int j =  0; j < arr.length; j++) {
                if (!visited[j]) {
                    dfsUtil(visited, arr, j);
                    count++;
                }
            }


        System.out.println(count);
    // return count;
    }

    private static void dfsUtil(boolean[] visited, int[][] arr, int i) {

        for (int j = 0; j < arr.length; j++) {
            if (arr[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfsUtil(visited, arr, j);
            }
        }

    }
}
