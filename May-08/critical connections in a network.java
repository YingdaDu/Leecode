/*
An edge is critical connection, if and only if it is not in a cycle

low[u] records the lowest vertex u can reach
disc[u] records the time when u was discovered
if low[v] > disc[u]
    add vu
 */

class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] disc = new int[n];
        int[] low = new int[n];
        List<Integer>[] graph = new ArrayList[n]; // list of adjanency node
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc, -1);
        //build graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.size(); i++) {
            int from = connections.get(i).get(0);
            int to = connections.get(i).get(1);
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }
        return res;
    }

    int time = 0;

    private void dfs (int u, int[] low, int[] disc, List<Integer>[] graph, List<List<Integer>> res, int pre) {
        disc[u] = time;
        low[u] = time;
        time++;
        // for loop neighbors
        for (int j = 0; j < graph[u].size(); j++) {
            int v = graph[u].get(j);
            if (v == pre) {
                continue;
            }

            if (disc[v] == -1) { // v is not discovered, u is v parent
                dfs(v, low, disc, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u])  { //there is no way for v to reach back to u
                    res.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}