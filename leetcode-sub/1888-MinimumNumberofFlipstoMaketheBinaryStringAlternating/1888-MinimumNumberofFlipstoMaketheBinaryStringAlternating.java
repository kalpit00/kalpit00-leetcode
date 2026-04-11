// Last updated: 4/10/2026, 10:21:31 PM
1class Solution {
2    public int minArraySum(int[] nums, int k, int op1, int op2) {
3        int n = nums.length;
4        Integer[][][] dp = new Integer[n + 1][op1 + 1][op2 + 1];
5        return solve(nums, 0, n, op1, op2, dp, k);
6    }
7    private int solve(int[] nums, int i, int n, int op1, int op2,
8    Integer[][][] dp, int k) {
9        if (i >= n) {
10            return 0;
11        }
12        if (dp[i][op1][op2] != null) {
13            return dp[i][op1][op2];
14        }
15        int min = Integer.MAX_VALUE;
16        min = nums[i] + solve(nums, i + 1, n, op1, op2, dp, k);
17        if (op1 > 0) {
18            min = Math.min(min, (nums[i] + 1) / 2 + solve(nums, i + 1, n, op1 - 1, op2, dp, k));
19        }        
20        if (op2 > 0 && k <= nums[i]) {
21            min = Math.min(min, (nums[i] - k) + solve(nums, i + 1, n, op1, op2 - 1, dp, k));
22        }        
23        if (op1 > 0 && op2 > 0) {
24            int val = (nums[i] + 1) / 2;
25            if (k <= val) {
26                min = Math.min(min, (val - k) + solve(nums, i + 1, n, op1 - 1, op2 - 1, dp, k));
27            }
28            if (k <= nums[i]) {
29                val = nums[i] - k;
30                min = Math.min(min, (val + 1) / 2 + solve(nums, i + 1, n, op1 - 1, op2 - 1, dp, k));
31            }
32        }        
33        return dp[i][op1][op2] = min;
34    }
35}