// Last updated: 3/24/2025, 5:44:07 AM
class Solution {
    public int countDays(int days, int[][] intervals) {
        intervals = merge(intervals);
        int sum = 0;
        for (int[] interval : intervals) {
            int end = interval[1], start = interval[0];
            sum += end - start + 1; // range
        } // sum up ranges of all merged non-overlapping intervals
        return days - sum;
    }
    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[1] < curr[0]) {
                res.add(prev);
                prev = curr;
            } else {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        res.add(prev);
        return res.toArray(new int[0][]);
    }
}