class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        //use array of list to represent graph
        ArrayList<Integer>[] graph = new ArrayList[n];
        buildGraph(graph, connections);

        int[] disc = new int[n];
        int[] parent = new int[n];
        int[] low = new int[n];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {//unvistied
                dfs(graph, disc, low, parent, i, res);
            }
        }
        return res;
    }

    int time = 0;

    private void dfs(List<Integer>[] graph, int[] disc, int[] low,
                     int[] parent, int u, List<List<Integer>> res)  {
        if (disc[u] != -1) {
            return;
        }

        disc[u] = time;
        low[u] = time;
        time++;

        for (int v : graph[u]) {

            if (disc[v] == -1) {
                parent[v] = u;
                dfs(graph, disc, low, parent, v, res);

                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }

                low[u] = Math.min(low[v], low[u]);
            } else if (parent[u] != v) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    private void buildGraph(ArrayList<Integer>[] graph, List<List<Integer>> connections) {
        for (List<Integer> conn : connections) {
            int a = conn.get(0);
            int b = conn.get(1);

            if (graph[a] == null) {
                graph[a] = new ArrayList<Integer>();
            }
            graph[a].add(b);

            if (graph[b] == null) {
                graph[b] = new ArrayList<Integer>();
            }
            graph[b].add(a);
        }
    }
}