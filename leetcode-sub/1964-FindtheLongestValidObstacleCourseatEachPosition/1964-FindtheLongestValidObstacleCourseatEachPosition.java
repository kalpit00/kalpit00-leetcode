// Last updated: 2/12/2026, 11:29:19 PM
1class Solution {
2    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
3        int n = nums.length, len = 0;
4        int[] lis = new int[n], dp = new int[n];
5        for (int i = 0; i < n; i++) {
6            int idx = upperBound(dp, len, nums[i]);
7            dp[idx] = nums[i];
8            len += (idx == len) ? 1 : 0;
9            lis[i] = idx + 1;
10        }
11        return lis;
12    }
13    private int upperBound(int[] dp, int n, int x) {
14        int start = 0, end = n, ans = n;
15        while (start <= end) {
16            int mid = start + (end - start) / 2;
17            if (dp[mid] > x) {
18                ans = mid;
19                end = mid - 1;
20            }                
21            else {
22                start = mid + 1;
23            }
24        }
25        return ans;
26    }
27}
28