/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        //key: element value: frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        int max  = 0;
        for (int num : nums) {
            if (!map.containsKey(num)){
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int len = left + right + 1;

                max = Math.max(max, len);
                map.put(num, len);

                //update boundary
                map.put(num - left, len);
                map.put(num + right, len);
            }

        }
        return max;
    }
}