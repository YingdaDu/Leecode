class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //need to make sure m <= n
        if (m > n) {
            int[] tmp = nums1; nums1 = nums2; nums2 = tmp;
            int temp = m; m = n; n = temp;
        }
        int left = 0, right = m;
        int len = (m + n + 1)/2; // left side has len elements

        while (left <= right) {
            //nums1 has mid elements in the left side
            int mid = left + (right - left) / 2;
            // nums2 has r_left elements in the left side
            int r_left = len - mid;

            /*
            make sure all the element on the left less than all the elements on the right
            1, 3, 4
            2, 3, 6
             */
            if (mid > 0 && nums1[mid-1] > nums2[r_left])  { // nums1 should have less elements
                right = mid - 1;
            } else if (mid < m && nums2[r_left-1] > nums1[mid]){ //nums1 should have more elements
                left = mid + 1;
            } else {
                // find max left
                int maxLeft = Integer.MAX_VALUE;
                if (mid == 0) {
                    maxLeft = nums2[r_left-1];
                } else if (r_left == 0) {
                    maxLeft = nums1[mid-1];
                } else {
                    maxLeft = Math.max(nums1[mid-1], nums2[r_left-1]);
                }
                if ((m+n) % 2== 1) {
                    return maxLeft;
                }
                int minRight = Integer.MAX_VALUE;
                if (mid == m) {
                    minRight = nums2[r_left];
                } else if (r_left == n) {
                    minRight = nums1[mid];
                } else {
                    minRight = Math.min(nums1[mid], nums2[r_left]);
                }
                return (maxLeft + minRight)/2.0;
            }

        }
        return 0.0;
    }
}