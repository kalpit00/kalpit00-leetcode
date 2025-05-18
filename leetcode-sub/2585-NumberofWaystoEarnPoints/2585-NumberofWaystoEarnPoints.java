// Last updated: 5/18/2025, 12:21:56 PM
class Solution {
    int mod = 1000000007;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        Long[][] dp = new Long[n][target + 1];
        return (int) solve(0, n, 0, target, types, dp);
    }
    private long solve(int i, int n, int sum, int target, 
    int[][] types, Long[][] dp) {
        if (sum == target) {
            return 1;
        }
        if (i >= n || sum > target) {
            return 0;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        long notTake = solve(i + 1, n, sum, target, types, dp);
        long take = 0; // there are [1, 2, .. count] # of questions of type 'i'
        for (int j = 1; j <= types[i][0]; j++) {
            int marks = types[i][1]; // each question is worth 'marks'
            if (sum + j * marks > target) break;
            take += solve(i + 1, n, sum + (j * marks), target, types, dp) % mod;
        }
        return dp[i][sum] = (take % mod + notTake % mod) % mod;
    }
}