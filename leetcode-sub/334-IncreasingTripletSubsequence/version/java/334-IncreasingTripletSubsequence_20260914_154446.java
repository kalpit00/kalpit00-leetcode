// Last updated: 9/14/2026, 3:44:46 PM
1class Solution {
2    public boolean increasingTriplet(int[] nums) {
3        int n = nums.length;
4        int[] pre = new int[n], suf = new int[n];
5        pre[0] = nums[0]; // or use int_max
6        suf[n - 1] = nums[n - 1]; // use int_min
7        for (int i = 1; i < n; i++) {
8            pre[i] = Math.min(pre[i - 1], nums[i]);
9        }
10        for (int i = n - 2; i >= 0; i--) {
11            suf[i] = Math.max(suf[i + 1], nums[i]);
12        }
13        for (int i = 1; i < n - 1; i++) {
14            if (pre[i - 1] < nums[i] && suf[i + 1] > nums[i]) {
15                return true;
16            }
17        }
18        return false;
19    }
20}