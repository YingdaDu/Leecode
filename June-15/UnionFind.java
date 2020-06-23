/*
Find(x): find the root/cluster-id of x
Union(x, y): merge two clusters

check two elements are in the same set or not in O(1)

find: O(a(n))* = O(1)
union: O(a(n))* = O(1)
Space: O(n)

without optimization: find: O(n)
two key optimization:
1) path compression : make tree flat -- in find function
2) Union by rank: merge low rank tree to high rank none   --- in union function

amortized
 */

class UnionFind {
    private int[] parent;
    private int[] ranks;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; //initialize;
        }
        ranks = new int[n];
        Arrays.fill(ranks, 0);
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) return false;

        if (ranks[parentX] < ranks[parentY]) {
            parent[parentX] = parentY;
        } else if (ranks[parentX] > ranks[parentY]) {
            parent[parentY] = parentX;
        } else {
            parent[parentY] = parentX;
            ranks[parentX]++;
        }
        return true;
    }
}
