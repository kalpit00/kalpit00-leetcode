// Last updated: 8/30/2026, 2:01:11 AM
1class Solution {
2    public int minimumDeletions(int[] nums) {
3        int n = nums.length, minidx = 0, maxidx = 0;
4        for (int i = 0; i < n; i++) {
5            if (nums[i] < nums[minidx]) {
6                minidx = i;
7            }
8            if (nums[i] > nums[maxidx]) {
9                maxidx = i;
10            }
11        }
12        int l = Math.min(minidx, maxidx), r = Math.max(minidx, maxidx);
13        return Math.min(Math.min(r + 1, n - l), l + 1 + n - r);
14    }
15}