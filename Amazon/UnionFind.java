public class Solution {
    /**
     * @param ListA: The relation between ListB's books
     * @param ListB: The relation between ListA's books
     * @return: The answer
     */
    public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
        HashMap<String, Integer> bookToId = new HashMap<>();
        HashMap<Integer, String> idToBook = new HashMap<>();

        int idx = 0;
        for (int i = 0; i < ListA.length; i++) {
            if (!bookToId.containsKey(ListA[i])) {
                bookToId.put(ListA[i], idx);
                idToBook.put(idx, ListA[i]);
                idx++;
            }
            if (!bookToId.containsKey(ListB[i])) {
                bookToId.put(ListB[i], idx);
                idToBook.put(idx, ListB[i]);
                idx++;
            }
        }

        UnionFind uf = new UnionFind(idx);

        for (int i = 0; i < ListA.length; i++) {
            uf.find(ListA[i], ListB[i]);
        }

        int[] size = uf.getSize();
        int max = 0;
        int id = 0;
        for (int i = 0; i < size.length; i++) {
            if (size[i] > max) {
                max = size[i];
                id = i;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < size.length; i++) {
            if (uf.find(i) == id) {
                ans.add(idToBook.get(i));
            }
        }
        return res;
    }

    class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int find (int x) {
            while (x != parent[x]) {
               parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) return false;

            if (size[parentX] < size[parentY]) {
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            } else {
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            }
            return true;
        }

        public int[] getSize() {
            return size;
        }
    }
}