// Last updated: 3/31/2026, 4:12:22 PM
1class Solution {
2    public int minimumNumbers(int num, int k) {
3        if (num == 0) return 0;
4        if (k == 0) {
5            if (num % 10 == 0) {
6                return 1;
7            }
8            return -1;
9        }
10        List<Integer> list = new ArrayList<>();
11        for (int i = 0; i <= num; i++) {
12            if (i % 10 == k) {
13                list.add(i);
14            }
15        }
16        int[] coins = new int[list.size()];
17        for (int i = 0; i < coins.length; i++) {
18            coins[i] = list.get(i);
19        }
20        return coinChange(coins, num);
21    }
22    public int coinChange(int[] coins, int amount) {
23        int n = coins.length;
24        Integer[][] dp = new Integer[n][amount + 1];
25        int res = solve(0, coins, 0, amount, dp);
26        return res == Integer.MAX_VALUE ? -1 : res;
27    }
28    
29    private int solve(int i, int[] nums, int sum, int target, Integer[][] dp) {
30        if (sum == target) {
31            return 0;
32        }
33        if (i >= nums.length || sum > target) {
34            return Integer.MAX_VALUE;
35        }
36        if (dp[i][sum] != null) {
37            return dp[i][sum];
38        }
39        int notTake = solve(i + 1, nums, sum, target, dp);
40        int take = Integer.MAX_VALUE;
41        if (nums[i] <= target - sum) {
42            int res = solve(i, nums, sum + nums[i], target, dp);
43            if (res != Integer.MAX_VALUE) {
44                take = 1 + res;
45            }
46        }
47        return dp[i][sum] = Math.min(take, notTake);
48    }
49}