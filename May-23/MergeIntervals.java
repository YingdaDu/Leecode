class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        //sort
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] temp = intervals[0];

        for (int[] interval : intervals) {
            if (interval[0] <= temp[1]) {//overlap
                temp[1] = Math.max(interval[1], temp[1]);
            } else {
                res.add(temp);
                temp = interval;
            }
        }
        res.add(temp);//important
        return res.toArray(new int[res.size()][]);
    }
}