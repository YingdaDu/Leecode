class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] val = map.values().stream().mapToInt(i -> i).toArray();
        Arrays.sort(val);
        int res = val.length;
        for (int i : val) {
            if(k < i) break;
            k -= i;
            res--;
        }
        return res;
    }
}