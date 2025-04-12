// Last updated: 4/12/2025, 3:20:40 AM
class Solution {
    int mod = 1000000007;
    public int sumOfPower(int[] nums, int k) {
        reverseSort(nums);
        int n = nums.length;
        Integer[][][] dp = new Integer[n + 1][n + 1][k + 1];
        return solve(nums, 0, n, k, 0, 0, dp);
    }
    private int solve(int[] nums, int i, int n, int k, int sum, int count, 
    Integer[][][] dp) {
        if (sum == k) {
            return helper(n - count); // ftn to calc 2^(x) with mod!
        }
        if (i >= n || sum > k) {
            return 0;
        }
        if (dp[i][count][sum] != null) {
            return dp[i][count][sum];
        }
        int take = solve(nums, i + 1, n, k, sum + nums[i], count + 1, dp);
        int notTake = solve(nums, i + 1, n, k, sum, count, dp);
        return dp[i][count][sum] = (take + notTake) % mod;
    } // ftn for binary exponential, implementing 2^n with mod for overflow!
    private int helper(int n) {
        long a = 2;
        long res = 1L;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            n /= 2;
        }
        return (int) res;
    }
    private void reverseSort(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}