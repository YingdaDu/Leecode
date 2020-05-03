/*
Template:
[l, r]

def binary_search(l, r):
    while (l <= r):
        m = l + (r-l)/2;
        if f(m): return m // Optional
        if g(m):
            r = m-1  // new range[l, m-1]
        else:
            l = m+1 // new range[m+1, r)
     return l or r // depends or not found

[l, r) the template is useful when cannot determine the ==
def binary_search(l, r):
    while (l < r):
        m = l + (r-l)/2;
        if f(m): return m // Optional
        if g(m):
            r = m // new range[l, r)
        else:
            l = m+1 // new range[m+1, r)
     return l // depends or not found


     time complexity: O(log(r-1) * (f(m) + g(m)))
 */
// 704. Binary Search basic
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l)/ 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    // 34.  Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int left = searchBound(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return ans;
        }
        ans[0] = left;
        ans[1] = searchBound(nums, target, false)-1;
        return ans;

    }

    public int searchBound(int[] nums, int target, boolean islow) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] > target || (islow && nums[m] == target)) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    // 69. sqrt(x)
    public int mySqrt(int x) {
        // [l , r]
        int l = 1;
        int r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (m > x / m) { // to aviod overflow
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
    //278. First Bad Version
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int m = l + (r -l)/2;
            if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    // 875. Koko eating banana
    // find min K such that she can eat all the bananas within H hours
    public int minEatingSpeed(int[] piles, int H) {
        int r = Arrays.stream(piles).max().getAsInt();  // remeber it
        int l = 1; // start at l since will divide it later and range is [l, r]

        while (l <= r) {
            int m = l + (r - l)/2;
            int h = 0;
            for (int i = 0; i < piles.length; i++) {
                h += ((piles[i] + m - 1) / m);
            }
            if (h <= H) { // can finish
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    // 378. Kth
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

}