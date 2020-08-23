class Solution {
    public int[] FlightDetails(int[] arr, int k) {
        k -= 30;
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            idxMap.put(arr[i], i);
        }
        Arrays.sort(arr);

        int[] res = new int{-1, -1};

        int = arr.length;

        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (arr[left] + arr[right] > k) {
                right --;
            } else {
                if (arr[left] + arr[right] > res[0] + res[1] || Math.max(arr[left], arr[right]) > Math.max(res[0], res[1])) {
                    res[0] = arr[left];
                    res[1] = arr[right];
                }
                left++;
            }
        }
        int lidx = idxMap.get(res[0]);
        int ridx = idxMap.get(res[1]);

        if(lidx > ridx){
            res[0] = ridx;
            res[1] = lidx;
        }else{
            res[0] = lidx;
            res[1] = ridx;
        }

        return res;

    }


    private static int[] Find2Sum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] res = new int[] {-1, -1};
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                if(nums[i] > max || nums[map.get(nums[i])] > max) {
                    res[0] = map.get(nums[i]);
                    res[1] = i;
                    max = Math.max(nums[i], nums[map.get(nums[i])]);
                }
            }
            map.put(target - nums[i], i);
        }
        return res;
    }


}