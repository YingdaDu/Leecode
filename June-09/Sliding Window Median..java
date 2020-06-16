/*
i = Arrays.binarySearch(array, val)
i is the insertion index if found in window
else i = -(insertpoint) - 1
 */

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(k == 0) return new double[0];

        double[] ans = new double[nums.length - k + 1];
        double[] window = new double[k];
        for (int i = 0; i < k; i++) window[i] = nums[i];
        Arrays.sort(window);

        for (int i = k; i <= nums.length; i++) {
            ans[i-k] = ((double)(window[k/2] + window[(k-1)/2]))/2;
            if(i == nums.length) break;
            remove(window, nums[i-k]);
            insert(window, nums[i]);
        }
        return ans;
    }

    private void remove(double[] window, int val) {
        int i = Arrays.binarySearch(window, val);
        while(i < window.length - 1) window[i] = window[++i];
    }

    private void insert(double[] window, int val) {
        int i = Arrays.binarySearch(window, val);
        if (i < 0) i = -i-1;
        int j = window.length-1;
        while(j > i) window[j] = window[--j];
        window[j] = val;
    }
}