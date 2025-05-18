// Last updated: 5/18/2025, 1:03:11 PM
class Solution {
    public long minimumTotalDistance(List<Integer> robots, int[][] factories) {
        Collections.sort(robots);
        Arrays.sort(factories, (a, b) -> a[0] - b[0]);
        List<Integer> nums = new ArrayList<>();
        for (int[] factory : factories) {
            for (int i = 0; i < factory[1]; i++) {
                nums.add(factory[0]);
            }
        }
        int m = robots.size(), n = nums.size();
        Long[][] dp = new Long[m + 1][n + 1];
        return solve(0, 0, m, n, robots, nums, dp);
    }
    private long solve(int i, int j, int m, int n, List<Integer> robots,
    List<Integer> nums, Long[][] dp) {
        if (i == m) {
            return 0;
        }
        if (j == n) {
            return (long) 1e13;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        long take = solve(i + 1, j + 1, m, n, robots, nums, dp) + Math.abs(robots.get(i) - nums.get(j));
        long notTake = solve(i, j + 1, m, n, robots, nums, dp);
        return dp[i][j] = Math.min(take, notTake);
    }
}