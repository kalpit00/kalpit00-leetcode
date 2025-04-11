// Last updated: 4/10/2025, 8:30:55 PM
class Solution {
    public int numDupDigitsAtMostN(int n) {
        int m = (int) Math.log10(n) + 1;
        Integer[][][][] dp = new Integer[m][1 << 10][2][2];
        int[] num = helper(n, m);
        return solve(num, 0, m, 1, 0, 0, dp);
    }
    private int solve(int[] num, int idx, int m, int tight, int mask, 
    int repeated, Integer[][][][] dp) {
        if (idx == m) {
            return repeated == 1 ? 1 : 0;
        }
        if (dp[idx][mask][tight][repeated] != null) {
            return dp[idx][mask][tight][repeated];
        }
        int limit = tight == 1 ? num[idx] : 9;
        int count = 0;
        for (int i = 0; i <= limit; i++) {
            int newTight = tight == 1 && i == limit ? 1 : 0;
            if (i == 0 && mask == 0) {
                count += solve(num, idx + 1, m, newTight, mask, 0, dp);
            } // can also just use repeated = 0 when leading zeros.
            else if ((mask & (1 << i)) != 0) {
                count += solve(num, idx + 1, m, newTight, mask, 1, dp);
            }
            else {
                count += solve(num, idx + 1, m, newTight, mask | (1 << i), repeated, dp);
            }
        }
        return dp[idx][mask][tight][repeated] = count;
    }

    private int[] helper(int n, int m) {
        int[] num = new int[m];
        int i = m - 1;
        while (n > 0) {
            num[i--] = n % 10;
            n /= 10;
        }
        return num;
    }
}