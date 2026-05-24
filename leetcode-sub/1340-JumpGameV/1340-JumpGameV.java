// Last updated: 5/24/2026, 2:32:41 AM
1class Solution {
2    public int maxJumps(int[] nums, int d) {
3        int n = nums.length, max = 1;
4        Integer[] dp = new Integer[n];
5        for (int i = 0; i < n; i++) {
6            max = Math.max(max, dfs(i, nums, dp, d, n));
7        }
8        return max;
9    }
10    private int dfs(int i, int[] nums, Integer[] dp, int d, int n) {
11        if (dp[i] != null) {
12            return dp[i];
13        }
14        int max = 1;
15        for (int j = i + 1; j < n && j - i <= d; j++) {
16            if (nums[j] >= nums[i]) break;
17            max = Math.max(max, 1 + dfs(j, nums, dp, d, n));
18        }
19        for (int j = i - 1; j >= 0 && i - j <= d; j--) {
20            if (nums[j] >= nums[i]) break;
21            max = Math.max(max, 1 + dfs(j, nums, dp, d, n));
22        }
23        return dp[i] = max;
24    }
25}