// Last updated: 5/24/2025, 4:38:16 PM
class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int dest = (1 << n) - 1;
        int[] prereq = new int[n];
        for (int[] rel : relations) {
            int u = rel[0] - 1, v = rel[1] - 1;
            prereq[v] |= 1 << u;
        }
        int[] dp = new int[dest + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int mask = 0; mask <= dest; mask++) {
            int available = 0;
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0 && (mask & prereq[u]) == prereq[u]) {
                    available |= 1 << u;
                }
            }
            for (int subset = available; subset > 0; subset = (subset - 1) & available) {
                if (Integer.bitCount(subset) > k) continue;
                int nextMask = mask | subset;
                dp[nextMask] = Math.min(dp[nextMask], dp[mask] + 1);
            }
        }
        
        return dp[dest];
    }
}
