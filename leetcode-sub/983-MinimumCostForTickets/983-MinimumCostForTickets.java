// Last updated: 7/20/2025, 12:57:29 PM
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer dp[] = new Integer[366];
        Set<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        return solve(1, n, set, dp, days, costs);
    }
    private int solve(int i, int n, Set<Integer> set, Integer[] dp,
    int[] days, int[] costs) {
        if (i > days[n - 1]) {
            return 0;
        }
        if (!set.contains(i)) {
            return solve(i + 1, n, set, dp, days, costs);
        }
        if (dp[i] != null) {
            return dp[i];
        }
        int a = costs[0] + solve(i + 1, n, set, dp, days, costs);
        int b = costs[1] + solve(i + 7, n, set, dp, days, costs);
        int c = costs[2] + solve(i + 30, n, set, dp, days, costs);
        return dp[i] = Math.min(a, Math.min(b, c));
    }
}