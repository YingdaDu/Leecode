class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || K <= 0) {
            return new int[0][0];
        }
        //max heap
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> ((b[0] * b[0] + b[1]* b[1]) - (a[0]*a[0] + a[1] * a[1])));

        for (int[] p : points) {
            queue.add(p);
            if (queue.size() > K) {
                queue.poll();
            }
        }

        int size = Math.min(queue.size(), K);
        int[][] ans = new int[size][2];

        for (int j = size - 1; j >= 0; j--) {
            ans[j] = queue.poll();
        }
        return ans;
    }

    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || K <= 0) {
            return new int[0][0];
        }
        //min heap
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> ((a[0] * a[0] + a[1]* a[1]) - (b[0]*b[0] + b[1] * b[1])));

        for (int[] p : points) {
            queue.add(p);
        }
        int[][] ans = new int[K][2];
        int idx = K - 1;
        while (idx >= 0) {
            ans[idx] = queue.poll();
            idx--;
        }
        return ans;
    }
}