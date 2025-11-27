// Last updated: 11/27/2025, 6:24:30 AM
1class Solution {
2    public long maxSubarraySum(int[] nums, int k) {
3        int n = nums.length;
4        long sum = 0, max = Long.MIN_VALUE;
5        long[] pre = new long[k];
6        for (int i = 0; i < k; i++) {
7            pre[i] = Long.MAX_VALUE / 2;
8        }
9        pre[k - 1] = 0;
10        for (int i = 0; i < n; i++) {
11            sum += nums[i];
12            max = Math.max(max, sum - pre[i % k]);
13            pre[i % k] = Math.min(pre[i % k], sum);
14        }
15        return max;
16    }
17}