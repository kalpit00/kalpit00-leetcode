// Last updated: 11/20/2025, 2:18:40 PM
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? 
        a[1] - b[1] : b[0] - a[0]);
        int count = 2, n = intervals.length;
        int[] prev = new int[]{intervals[0][1] - 1, intervals[0][1]};
        for (int i = 1; i < n; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= prev[0]) continue;
            if (prev[1] < curr[0]) {
                prev[0] = curr[1] - 1;
                count += 2;
            }
            else {
                prev[0] = prev[1];
                count++;
            }
            prev[1] = curr[1];
        }
        return count;
    }
}