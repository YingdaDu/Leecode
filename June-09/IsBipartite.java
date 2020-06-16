/*
color the node into two color set
 */
class Solution {
    //BFS
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0) { //already colored
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;// two color 1 ans -1

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        colors[next] = - colors[cur];
                        queue.add(next);
                    } else if (colors[next] != -colors[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // DFS
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int color, int i) {
        if (colors[i] != 0) {
            return colors[i] == color;
        }
        colors[i] = color;

        for (int next : graph[i]) {
            if (!dfs(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }
}