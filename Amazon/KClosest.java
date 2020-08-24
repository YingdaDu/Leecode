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

    public int[][] kClosest(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}