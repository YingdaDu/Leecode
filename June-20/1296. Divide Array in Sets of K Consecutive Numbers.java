/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.
 */
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int num : nums) {
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        for (int num : treeMap.keySet()) {
            if (treeMap.get(num) > 0) {
                for (int i = k-1; i >=0; i--) {
                    if (treeMap.getOrDefault(num+i, 0) < treeMap.get(num)) return false;

                    treeMap.put(num+i, treeMap.get(num+i)-treeMap.get(num));
                }
            }
        }
        return true;
    }
}