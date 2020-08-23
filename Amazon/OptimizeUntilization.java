public class OptimalUtilization{
    public List<int[]> utilization(List<int[]> a, List<int[]> b, int target){
        Map<Integer, List<int[]>> = new HashMap<>();

        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                int sum = a.get(i)[1] + b.get(i)[1];
                List<int[]> sums = map.getOrDefault(sum, new ArrayList<int[]>());
                sums.add(new int[] {a.get{i}[0], b.get(i)[1]});
                map.put(sum, sums);
            }
        }

        List<int[]> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Integer i : map.keySet()) {
            if (i <= target && i > max) {
                max = i;
                ans = map.get(i);
            }
        }
        return max == Integer.MAX_VALUE ? new ArrayList<int[]>() : ans;
    }
}