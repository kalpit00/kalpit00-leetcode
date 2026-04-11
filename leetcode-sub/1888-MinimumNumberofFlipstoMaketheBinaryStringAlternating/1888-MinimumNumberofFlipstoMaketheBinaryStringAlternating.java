// Last updated: 4/10/2026, 10:43:37 PM
1class Solution {
2    public int minArraySum(int[] nums, int k, int op1, int op2) {
3        int n = nums.length;
4        Integer[][][] dp = new Integer[n + 1][op1 + 1][op2 + 1];
5        return solve(nums, 0, n, op1, op2, dp, k);
6    }
7    private int solve(int[] nums, int i, int n, int op1, int op2,
8        Integer[][][] dp, int k) {
9        if (i >= n) {
10            return 0;
11        }
12        if (dp[i][op1][op2] != null) {
13            return dp[i][op1][op2];
14        }        
15        int notTake = nums[i] + solve(nums, i + 1, n, op1, op2, dp, k);        
16        int take1 = (op1 > 0) ? solve(nums, i + 1, n, op1 - 1, op2, dp, k) + 
17        (nums[i] + 1) / 2 : Integer.MAX_VALUE;
18        int take2 = (op2 > 0 && k <= nums[i]) ? (nums[i] - k) + 
19        solve(nums, i + 1, n, op1, op2 - 1, dp, k) : Integer.MAX_VALUE;
20        int takeBoth = Integer.MAX_VALUE;
21        if (op1 > 0 && op2 > 0) {
22            int val = (nums[i] + 1) / 2;
23            if (k <= val) {
24                takeBoth = Math.min(takeBoth, (val - k) + solve(nums, i + 1, n, op1 - 1, op2 - 1, dp, k));
25            }            
26            if (k <= nums[i]) {
27                val = nums[i] - k;
28                takeBoth = Math.min(takeBoth, (val + 1) / 2 + solve(nums, i + 1, n, op1 - 1, op2 - 1, dp, k));
29            }
30        }        
31        int min = Math.min(notTake, Math.min(take1, Math.min(take2, takeBoth)));
32        return dp[i][op1][op2] = min;
33    }
34}