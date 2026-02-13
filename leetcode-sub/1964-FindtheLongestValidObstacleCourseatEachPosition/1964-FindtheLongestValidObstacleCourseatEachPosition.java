// Last updated: 2/12/2026, 9:25:54 PM
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
13
14    private int upperBound(int[] dp, int n, int x) {
15        int start = 0, end = n, ans = n;
16        while (start <= end) {
17            int mid = start + (end - start) / 2;
18            if (dp[mid] > x) {
19                ans = mid;
20                end = mid - 1;
21            }                
22            else {
23                start = mid + 1;
24            }
25        }
26        return ans;
27    }
28}
29