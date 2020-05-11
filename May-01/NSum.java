class Solution {
    //simpliest two sum
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
                return ans;
            } else {
                map.put(target-nums[i], i);
            }
        }
        return ans;
    }
    //167. Two Sum II - Input array is sorted
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{l+1, r+1};
            } else if (target > sum) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }

}