class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length) {
                i++;
            } else if (nums[i] != nums[nums[i]-1]){
                swap(nums, i, nums[i]-1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i+1) i++;
        return i+1;
    }
}