class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> major = null;

        for (Map.Entry<Integer, Integer> num : counts.entrySet()) {
            if (major == null || major.getValue() < num.getValue()) {
                major = num;
            }
        }
        return major.getKey();
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return counts;
    }


    public int majorityElement(int[] nums) {

        int count = 0;
        Integer major = null;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) major = nums[i];

            count += (nums[i] == major) ? 1 : -1;
        }
        return major;
    }
}