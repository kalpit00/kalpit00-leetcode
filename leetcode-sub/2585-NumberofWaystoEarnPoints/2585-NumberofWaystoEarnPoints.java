// Last updated: 5/18/2025, 11:31:03 AM
class Solution {
    int mod = 1000000007;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        Long[][] dp = new Long[n][target + 1];
        return (int) solve(0, n, target, types, dp);
    }
    private long solve(int i, int n, int sum, int[][] types, Long[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (i >= n || sum < 0) {
            return 0;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        long notTake = solve(i + 1, n, sum, types, dp);
        long take = 0; // there are [1, 2, .. count] # of questions of type 'i'
        for (int j = 1; j <= types[i][0]; j++) {
            int marks = types[i][1]; // each question is worth 'marks'
            if (sum < j * marks) break;
            take += solve(i + 1, n, sum - (j * marks), types, dp) % mod;
        }
        return dp[i][sum] = (take % mod + notTake % mod) % mod;
    }
}