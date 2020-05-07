//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

public int findMaxLength(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        int[] sum = new int[n];
        int cur = 0;
        for (int i = 0;   i < n; i++) {
            cur += nums[i];
            sum[i] = cur;
        }

        Map<Integer, Integer> map = new HashMap<>(); // key:prefixSum, value: first occurance
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] == 0) {
                res = Math.max(res, i+1);
            } else if (map.containsKey(sum[i])) {
                res = Math.max(res, i - map.get(sum[i]));
            } else {
                map.put(sum[i], i);
            }
        }
        return res;
}