class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len =  nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int lo = i + 1, hi = len - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target){
                    count += (hi - lo);
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }
}