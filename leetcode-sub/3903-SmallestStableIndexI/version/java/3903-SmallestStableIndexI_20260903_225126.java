// Last updated: 9/3/2026, 10:51:26 PM
1class Solution {
2    public int firstStableIndex(int[] nums, int k) {
3        int n = nums.length;
4        int[] pre = new int[n], suf = new int[n];
5        pre[0] = nums[0];
6        suf[n - 1] = nums[n - 1];
7        for (int i = 1; i < n; i++) {
8            pre[i] = Math.max(pre[i - 1], nums[i]);
9        }
10        for (int i = n - 2; i >= 0; i--) {
11            suf[i] = Math.min(suf[i + 1], nums[i]);
12        }
13        for (int i = 0; i < n; i++) {
14            if (pre[i] - suf[i] <= k) {
15                return i;
16            }
17        }
18        return -1;
19    }
20}