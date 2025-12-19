// Last updated: 12/19/2025, 3:49:43 AM
1class Solution {
2    public int eraseOverlapIntervals(int[][] intervals) {
3        int n = intervals.length, count = 1;
4        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
5        int end = intervals[0][1];
6        for (int i = 1; i < n; i++) {
7            if (intervals[i][0] >= end) {
8                count++;
9                end = intervals[i][1];
10            }
11        }
12        return n - count;
13    }
14}