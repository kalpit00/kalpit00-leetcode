// Last updated: 2/3/2026, 12:10:31 AM
1class Solution {
2    public long minimumCost(String s) {
3        char[] nums = s.toCharArray();
4        int n = nums.length;
5        long min = Long.MAX_VALUE;
6        long[] pre = new long[n], suf = new long[n];
7        for (int i = 1; i < n; i++) {
8            pre[i] = pre[i - 1];
9            pre[i] += nums[i] != nums[i - 1] ? i : 0;
10        }
11        for (int i = n - 2; i >= 0; i--) {
12            suf[i] = suf[i + 1];
13            suf[i] += nums[i] != nums[i + 1] ? n - i - 1 : 0;
14        }
15        for (int i = 0; i < n; i++) {
16            min = Math.min(min, pre[i] + suf[i]);
17        }
18        return min;
19    }
20}