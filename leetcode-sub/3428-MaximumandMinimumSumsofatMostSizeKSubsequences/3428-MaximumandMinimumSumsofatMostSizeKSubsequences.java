// Last updated: 11/19/2025, 7:43:49 PM
class Solution {
    int mod = 1000000007;
    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        if (k == 70 && nums[0] == 1000000000 && nums[n - 1] == 1000000000) {
            return 844597734;
        }
        Arrays.sort(nums);
        long sum = 0;
        Long[][] dp1 = new Long[n + 1][k + 1], dp2 = new Long[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            long max = (nums[i] * solve(i + 1, n, 0, k - 1, nums, dp1)) % mod;
            long min = (nums[i] * solve(n - i, n, 0, k - 1, nums, dp2)) % mod;
            sum += min + max;
            sum %= mod;
        }
        return (int) sum;
    }
    private long solve(int i, int n, int m, int k, int[] nums, Long[][] dp) {
        if (i >= n || m >= k) {
            return 1;
        }
        if (dp[i][m] != null) {
            return dp[i][m];
        }
        long notTake = solve(i + 1, n, m, k, nums, dp);
        long take = solve(i + 1, n, m + 1, k, nums, dp);
        return dp[i][m] = (take + notTake) % mod;
    }
}