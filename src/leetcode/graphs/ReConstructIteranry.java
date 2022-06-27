package leetcode.graphs;

import java.util.*;

public class ReConstructIteranry {
    public static void main(String[] args) {
        String[][] input = new String[][]{
                {"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}
        };
        Map<String, ArrayList<String>> adjacencyList = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            adjacencyList.compute(input[i][0], (e,v) -> v == null ? new ArrayList<>() : v).add(input[i][1]);
        }
        adjacencyList.forEach((e,v) -> Collections.sort(v));
        System.out.println(adjacencyList);
        List<String> stringList = new ArrayList<>();
        Queue<ArrayList<String>> arrayLists = new LinkedList<>();
        arrayLists.add(adjacencyList.get("JFK"));
        stringList.add("JFK");

        while (!arrayLists.isEmpty()) {
            List<String> strings = arrayLists.poll();
            if (Objects.nonNull(strings) && !strings.isEmpty()) {
                String s = strings.remove(0);
                stringList.add(s);
                arrayLists.add(adjacencyList.get(s));
            }
        }
        System.out.println(stringList);
    }
}
