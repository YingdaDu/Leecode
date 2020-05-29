/*
find all the possible change

1. use bfs to find the shortest distance between start and end
2. Use dfs to output the path
 */

public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList); // word can be only used once
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> graph = new HashMap<>(); //neighbors
        List<String> solution = new ArrayList<>();

        set.add(start);
        bfs(start, end, set, graph, wordList);
        dfs(start, end, set, graph, res, solution);
        return res;
}

private void dfs(String start, String end,
                 HashSet<String> set,
                 HashMap<String, List<String>> graph,
                 List<String> wordList)

private void bfs(String start, String end,
                 HashSet<String> set,
                 HashMap<String, List<String>> graph,
                 List<String> wordList) {
       for (String s : set) {
           graph.put(s, new ArrayList<String>());
       }
       Queue<String> queue = new LinkedList<>();
       queue.offer(start);

       while (!queue.isEmpty()) {
           int size = queue.size();
           boolean found = false;
           for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                ArrayList<String> neighbors = getNeighbors(cur, set);

                for (String n : neighbors) {
                    graph.get(cur).add(n);
                    if (set.contains(n)) {
                        if (end.equals(n)){} found = true;
                        else {queue.add(n);

                    }
                }
           }
           if (found) break;
        }


}

private ArrayList<String> getNeighbors(String cur,
                                       HashSet<String> set) {
        ArrayList<String> res = new ArrayList<String>();
        char[] current = cur.toCharArray();

        for (int i = 0; i < cur.length; i++) {
            for (char c  = 'a'; c <= 'z'; c++ ) {
                if (current[i] == c) continue;
                char temp = current[i];
                current[i] = c;
                next = new String(next);
                if (set.contains(next)){
                    res.add(next);
                }
                current[i] = temp;
            }
        }
        return res;
}