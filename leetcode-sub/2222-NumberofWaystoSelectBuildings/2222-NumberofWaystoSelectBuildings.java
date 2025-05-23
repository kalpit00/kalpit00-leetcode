// Last updated: 5/23/2025, 12:42:33 PM
class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        Long[][][] dp = new Long[n][4][3];
        return solve(0, n, 0, s.toCharArray(), -1, dp);
    }
    private long solve(int i, int n, int count, char[] arr, 
    int prev, Long[][][] dp) {
        if (count == 3) {
            return 1;
        }
        if (i >= n) {
            return 0;
        }
        if (dp[i][count][prev + 1] != null) {
            return dp[i][count][prev + 1];
        }
        long notTake = solve(i + 1, n, count, arr, prev, dp);
        long take = (prev == -1 || arr[i] - '0' != prev) ? 
        solve(i + 1, n, count + 1, arr, arr[i] - '0', dp) : 0;
        return dp[i][count][prev + 1] = take + notTake;
    }
}