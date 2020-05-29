/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
sort
Arrays.copyOfRange(points, 0, K)
quick select
 The last solution is based on quick sort, we can also call it quick select. In the quick sort,
 we will always choose a pivot to compare with other elements. After one iteration, we will get
 an array that all elements smaller than the pivot are on the left side of the pivot and all
 elements greater than the pivot are on the right side of the pviot (assuming we sort the array
 in ascending order). So, inspired from this, each iteration, we choose a pivot and then find the
 position p the pivot should be. Then we compare p with the K, if the p is smaller than the K,
 meaning the all element on the left of the pivot are all proper candidates but it is not adequate,
 we have to do the same thing on right side, and vice versa. If the p is exactly equal to the K,
 meaning that we've found the K-th position.

 Theoretically, the average time complexity is O(N) , but just like quick sort, in the worst case,
  this solution would be degenerated to O(N^2)

  The advantage of this solution is it is very efficient.
The disadvatage of this solution are it is neither an online solution nor a stable one. And the K elements
closest are not sorted in ascending order.
 */

public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K - 1)  break;
            if (mid < K - 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
            return Arrays.copyOfRange(points, 0, K);
        }

private int helper (int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            while (l < r && compare(points[r], pivot) >= 0) r--;
            points[l] = points[r];
            while (l < r && compare(points[l], pivot) <= 0) l++;
            int[] temp = points[l];
            points[l] = points[r];
            points[r] = temp;
        }
        points[l] = pivot;
        return l;
}

private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
}


