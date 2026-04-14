// Last updated: 4/13/2026, 10:47:48 PM
1class Solution {
2    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
3        Collections.sort(robots);
4        Arrays.sort(factories, (a, b) -> a[0] - b[0]);
5        List<Integer> nums = new ArrayList<>();
6        for (int[] factory : factories) { // flatten 2d[][] -> 1d[]
7            for (int i = 0; i < factory[1]; i++) {
8                nums.add(factory[0]);
9            }
10        }
11        int m = robots.size(), n = nums.size();
12        Long[][] dp = new Long[m + 1][n + 1];
13        return solve(0, 0, m, n, robots, nums, dp);
14    }
15    private long solve(int i, int j, int m, int n, List<Integer> robots,
16    List<Integer> nums, Long[][] dp) {
17        if (i == m) {
18            return 0;
19        }
20        if (j == n) {
21            return (long) 1e13;
22        }
23        if (dp[i][j] != null) {
24            return dp[i][j];
25        }
26        long take = solve(i + 1, j + 1, m, n, robots, nums, dp) + 
27        Math.abs(robots.get(i) - nums.get(j));
28        long notTake = solve(i, j + 1, m, n, robots, nums, dp);
29        return dp[i][j] = Math.min(take, notTake);
30    }
31}