// Last updated: 5/17/2025, 8:35:45 PM
class Solution {
    private int[][] memo = new int[1000][1024];
    private int m, n;
    private final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        this.m = m;
        this.n = n;
        return dp(0, 0, 0, 0);
    }

    private int dp(int c, int prevColMask, int r, int curColMask) {
        if (c == n) return 1;
        if (r == 0 && memo[c][prevColMask] != 0) return memo[c][prevColMask];
        if (r == m) return dp(c + 1, curColMask, 0, 0);

        int ans = 0;
        for (int i = 1; i <= 3; ++i) { // Colors: 1 = RED, 2 = GREEN, 3 = BLUE
            if (getColor(prevColMask, r) != i && (r == 0 || getColor(curColMask, r - 1) != i)) {
                int newMask = setColor(curColMask, r, i);
                ans = (ans + dp(c, prevColMask, r + 1, newMask)) % MOD;
            }
        }

        if (r == 0) memo[c][prevColMask] = ans;
        return ans;
    }

    private int getColor(int mask, int pos) {
        return (mask >> (2 * pos)) & 3;
    }

    private int setColor(int mask, int pos, int color) {
        return mask | (color << (2 * pos));
    }
}
