// Last updated: 4/14/2025, 11:07:00 PM
public class Solution {
    int mod = 1000000007;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        Integer[][][] dp = new Integer[n + 1][max + 1][max + 1];
        return dfs(0, n, 0, 0, nums, dp);
    }
    private int dfs(int i, int n, int g1, int g2, int[] nums, 
    Integer[][][] dp) {
        if (i == n) {
            return (g1 == g2 && g1 != 0) ? 1 : 0;
        }
        if (dp[i][g1][g2] != null) {
            return dp[i][g1][g2];
        }
        long take1 = dfs(i + 1, n, (g1 == 0) ? nums[i] : gcd(g1, nums[i]), g2, nums, dp);
        long take2 = dfs(i + 1, n, g1, (g2 == 0) ? nums[i] : gcd(g2, nums[i]), nums, dp);
        long notTake = dfs(i + 1, n, g1, g2, nums, dp);
        return dp[i][g1][g2] = (int) ((take1 + take2 + notTake) % mod);
    }
    private int gcd(int a, int b) {
        return (b > 0) ? gcd(b, a % b) : a;
    }
}
