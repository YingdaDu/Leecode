class Solution {
    public int minDays(int[] A, int m, int k) {
        int n = A.length;
        int left = 1;
        int right = (int)1e9;

        if(m * k > n) return -1;

        while (left < right) {
            int mid = left + (right - left)/2;
            int bouq = 0, flow = 0;
            for (int j = 0; j < n; j++) {
                if(A[j] > mid) { // haven't bloom
                    flow = 0;
                } else {
                    flow++;
                    if (flow < k) continue;
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) { // not enough
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}