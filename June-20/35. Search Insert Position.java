class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int val = nums[mid];

            if (val < target) {
                left = mid + 1;
            } else if (val > target){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}