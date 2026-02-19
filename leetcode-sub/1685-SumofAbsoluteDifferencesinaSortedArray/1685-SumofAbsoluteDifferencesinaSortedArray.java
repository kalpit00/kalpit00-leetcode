// Last updated: 2/19/2026, 3:02:45 AM
1class Solution {
2    public int[] getSumAbsoluteDifferences(int[] nums) {
3        int n = nums.length;
4        int[] pre = new int[n], suf = new int[n], res = new int[n];
5        for (int i = 1; i < n; i++) {
6            pre[i] = pre[i - 1] + nums[i - 1];
7        }
8        for (int i = n - 2; i >= 0; i--) {
9            suf[i] = suf[i + 1] + nums[i + 1];
10        }
11        for (int i = 0; i < n; i++) {
12            res[i] = (suf[i] - (n - i - 1) * nums[i]) - (pre[i] - i * nums[i]);
13        }
14        return res;
15    }
16}