class Solution {
    public int singleNonDuplicate(int[] nums) {
        // if nums[i] == nums[i*] then choose right half
        int l = 0;
        int r = nums.length;

        while (l < r) {
            int m = l + (r -l) / 2;
            int n = m % 2 == 0 ? m + 1 : m - 1; // index = 3
            if (n >= 0 && n < nums.length && nums[n] == nums[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[l];
    }
}