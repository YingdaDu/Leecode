/*
Given an array of integers and an integer k,
you need to find the total number of continuous subarrays whose sum equals to k

[1-20000] means should be less than O(nlgn)
 */

/*
First native solution
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        sum[0] = 0; // have prefix
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        int count = 0;
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i+1; j <= nums.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
/*
Prefix sum using hashMap
keep tracking of the prefix sums and their counts
check how many arrays nums[0:j] j < i has sum = cur_sum - k
the they are the same num of arrays that nums[j+1, i] that have the sum k
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
       if (nums.length == 0) return 0;
       Map<Integer, Integer> sumMap = new HashMap<>();
       sumMap.put(0, 1);
       int count = 0, sum = 0;
       for (int i = 0; i < nums.length; i++) {
           sum += nums[i];
           if (sumMap.containsKey(sum - k)) {
               count += sumMap.get(sum-k);
           }
           sumMap.put(sum, map.getOrDefault(sum, 0) + 1);
       }
       return count;
    }
}

