// Last updated: 10/18/2026, 5:55:28 AM
1class Solution {
2    int mod = 1000000007;
3    public int numOfWays(int[] nums) {
4        int n = nums.length;
5        long[][] dp = new long[n][n];
6        List<Integer> arr = new ArrayList<>();
7        for (int i = 0; i < n; i++) {
8            arr.add(nums[i]);
9            dp[i][0] = dp[i][i] = 1;
10        }
11        for (int i = 2; i < n; i++) {
12            for (int j = 1; j < i; j++) {
13                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
14            }
15        }
16        return (int)(dfs(arr, dp) - 1);
17    }
18
19    private long dfs(List<Integer> nums, long[][] dp) {
20        int n = nums.size();
21        if (n < 3) return 1;
22        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
23        for (int i = 1; i < n; i++) {
24            if (nums.get(i) < nums.get(0)) {
25                left.add(nums.get(i));
26            }
27            else {
28                right.add(nums.get(i));
29            }
30        }
31        long leftWays = dfs(left, dp), rightWays = dfs(right, dp);
32        return (((leftWays * rightWays) % mod) * dp[n - 1][left.size()]) % mod;
33    }
34}