class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        HashMap<Integer, Map<Integer, Double>> graph = buildGraph(edges, succProb);

        pq.offer(new double[]{start, 1.0});

        HashSet<Integer> visited = new HashSet<>();
        double[] probs = new double[n];

        while (!pq.isEmpty()) {
            double[] cur = pq.poll();
            if (visited.contains((int)cur[0])) continue;
            visited.add((int)cur[0]);

            if((int)cur[0] == end) return cur[1];

            for (int neigh : graph.getOrDefault((int)cur[0], new HashMap<>()).keySet() ) {
                if(visited.contains(neigh)) continue;

                double prob = cur[1] * graph.get((int)cur[0]).get(neigh);
                if (prob > probs[neigh]) {
                    probs[neigh] = prob;
                    pq.offer(new double[]{neigh, prob});
                }
            }
        }

        return 0;
    }

    private HashMap<Integer, Map<Integer, Double>>  buildGraph(int[][] edges, double[] succProb) {
        HashMap<Integer, Map<Integer, Double>>  g = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            g.putIfAbsent(edges[i][0], new HashMap<>());
            g.putIfAbsent(edges[i][1], new HashMap<>());
            g.get(edges[i][0]).put(edges[i][1], succProb[i]);
            g.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }
        return g;
    }
}