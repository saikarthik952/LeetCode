package leetcode.graphs;

import java.util.*;

public class Solution {
    static class Node{
        Node parent;
        String str;
        Node(Node _parent, String _str){
            parent = _parent;
            str = _str;
        }

        List<String> generatePath(String end){
            List<String> result = new ArrayList<String>();
            for(Node n= this;n != null; n = n.parent)
                result.add(0, n.str);
            result.add(end);
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Arrays.<String>asList("hot","dot","dog","lot","log","cog")));
    }
//
//    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
//        dict.remove(start);
//        dict.remove(end);
//        Queue<Node> queue = new LinkedList<Node>();
//        queue.add(new Node(null, start));
//        queue.add(null);  //Level indicator
//        List<List<String>> result = new ArrayList<List<String>>();
//        Set<String> pendingVisited = new HashSet<String>();  //Very important to use set instead of list as it could have repeated items.
//        String[] dictArray = dict.toArray(new String[0]);  //ArrayList has much worse performance than raw Array.
//        Map<String, List<String>> neihborMap = new HashMap<String, List<String>>();
//        while(!queue.isEmpty()){
//            Node n = queue.poll();
//            if(n == null){
//                if(queue.isEmpty())
//                    break;
//
//                dict.removeAll(pendingVisited);
//                pendingVisited.clear();
//                dictArray = dict.toArray(new String[0]);
//                queue.add(n);
//                if(result.size() > 0)
//                    break;
//                continue;
//            }
//
//            if(isOneLetterChange(n.str, end)){
//                result.add(n.generatePath(end));
//            }else{
//                List<String> nbs = neihborMap.get(n.str);
//                if(nbs == null){
//                    nbs = findNeihbors(n.str, dictArray);
//                    neihborMap.put(n.str, nbs);
//                }
//
//                for(String s : nbs){
//                    queue.add(new Node(n, s));
//                    pendingVisited.add(s);
//                }
//            }
//        }
//        return result;
//    }
//
//    private static List<String> findNeihbors(String start, String[] dict){
//        List<String> neihbors = new ArrayList<String>();
//        for(String s : dict){
//            if(isOneLetterChange(start, s))
//                neihbors.add(s);
//        }
//        return neihbors;
//    }
//
//    private static boolean isOneLetterChange(String s1, String s2){
//        boolean hasDiff = false;
//        for(int i=0; i<s1.length(); i++){
//            if(s1.charAt(i) != s2.charAt(i)){
//                if(hasDiff)
//                    return false;
//                hasDiff = true;
//            }
//        }
//        return true;
//    }


    public static  List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> dict = new HashSet<String>(wordList);
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, HashSet<String>> nodeNeighbors = new HashMap<String, HashSet<String>>();// Neighbors for every node
        HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
        ArrayList<String> solution = new ArrayList<String>();

        dict.add(start);
        //bfs(start, end, dict, nodeNeighbors, distance);
       // dfs(start, end, dict, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private static void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean foundEnd = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor))// Found the shortest path
                            foundEnd = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.
    private static ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private static void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }

    // One-end, beat 80%; search from both ends will be even faster, since it can further eliminate half of the graph nodes, but the code is tricker, so here I stick with the one end solution.
// The key to avoid TLE is to minimize the size of the searching graph ( # of nodes and # of edges)
// And the key for the graph to also contains the ladder information is to avoid add edges connecting to strings from the previous level (e.g avoid any back-track path)
// Both of those two conditions can be satisfied by continously removing the strings of the current level from the wordDict...
    class Solution1 {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList();
            if (wordList == null || wordList.size() == 0) return res;
            Set<String> wordDict = new HashSet(wordList);
            if (!wordDict.contains(endWord)) return res;

            Map<String, List<String>> graph = new HashMap();
            Set<String> curLevel = new HashSet();

            curLevel.add(beginWord);
            boolean foundEnd = false;

            while (!curLevel.isEmpty() && !foundEnd) {
                wordDict.removeAll(curLevel); //this is important for minimizing the graph size, and avoid backtrack of the path
                Set<String> nextLevel = new HashSet();
                for (String s : curLevel) {
                    graph.put(s, new ArrayList<String>());
                    char[] cur = s.toCharArray();
                    for (int j = 0; j < cur.length; j++) {
                        char c = cur[j];
                        for (char r = 'a'; r <= 'z'; r++) {
                            if (r == c) continue;
                            cur[j] = r;
                            String temp = new String(cur);
                            if (!wordDict.contains(temp)) continue;
                            graph.get(s).add(temp);
                            nextLevel.add(temp);
                            if (temp.equals(endWord)) {
                                foundEnd = true;
                            };
                        }
                        cur[j] = c;
                    }
                }
                curLevel = nextLevel;
            }
            if (!foundEnd) return res;
            List<String> list = new ArrayList();
            list.add(beginWord);
            addPath(beginWord, endWord, res, graph, list);
            return res;
        }

        private void addPath(String from, String to,  List<List<String>> res,
                             Map<String, List<String>> graph, List<String> list) {
            if (from.equals(to)) {
                res.add(new ArrayList(list));
                return;
            }
            if (!graph.containsKey(from)) return;
            for (String next : graph.get(from)) {
                list.add(next);
                addPath(next, to, res, graph, list);
                list.remove(list.size() - 1);
            }
        }
    }
}