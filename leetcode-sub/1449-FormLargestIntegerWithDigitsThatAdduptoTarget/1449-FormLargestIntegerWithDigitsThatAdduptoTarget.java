// Last updated: 7/20/2025, 2:19:07 AM
class Solution {
    public String largestNumber(int[] cost, int target) {
        String[] dp = new String[target + 1];
        Arrays.fill(dp, null);
        dp[0] = "";
        String res = dfs(target, cost, dp);
        return res.equals("0") ? "0" : res;
    }
    private String dfs(int sum, int[] cost, String[] dp) {
        if (sum < 0) {
            return "0";
        }
        if (dp[sum] != null) {
            return dp[sum];
        }
        String max = "0";
        for (int d = 9; d >= 1; d--) {
            if (sum >= cost[d - 1]) {
                String sub = dfs(sum - cost[d - 1], cost, dp);
                if (!sub.equals("0")) {
                    String candidate = d + sub;
                    if (isLarger(candidate, max)) {
                        max = candidate;
                    }
                }
            }
        }
        return dp[sum] = max;
    }

    private boolean isLarger(String a, String b) {
        return a.length() > b.length() || 
        (a.length() == b.length() && a.compareTo(b) > 0);
    }
}
