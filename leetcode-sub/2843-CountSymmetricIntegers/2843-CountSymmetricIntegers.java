// Last updated: 4/11/2025, 12:41:22 AM
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int[] a = helper(low - 1), b = helper(high);
        int x = a.length, y = b.length;
        Integer[][][][] dp1 = new Integer[x][2][201][x + 1];
        Integer[][][][] dp2 = new Integer[y][2][201][y + 1];
        return solve(b, 0, 1, 0, 0, y, dp2) - solve(a, 0, 1, 0, 0, x, dp1);
    }

    private int solve(int[] digits, int idx, int tight, int sum, int lead, int m, Integer[][][][] dp) {
        int n = m - lead; // total - # leading zeros == gen num's length!
        if (idx == m) { // count way if generated num has even length > 0
            return (n > 0 && n % 2 == 0 && sum == 0) ? 1 : 0;
        } // and generated num is symmetric, meaning sum becomes 0
// sum became 0 as we added 1st half digits and subtracted 2nd half's digits
        if (dp[idx][tight][sum + 100][lead] != null) {
            return dp[idx][tight][sum + 100][lead];
        }
        int limit = (tight == 1 ? digits[idx] : 9), count = 0;
        for (int i = idx == lead ? 1 : 0; i <= limit; i++) { 
            int newTight = tight == 1 && i == limit ? 1 : 0; 
            int isFirstHalf = (idx - lead) < n / 2 ? 1 : -1;
            count += solve(digits, idx + 1, newTight, sum + isFirstHalf * i, lead, m, dp); // add digitsum for 1st half, subtract for 2nd half
        }
// extra dfs when idx is still on leading zero, increase # of leading zeroes by saying lead + 1 and adding nothing to sum! (tight stays 0 as we are yet to place any non-zero digit, so its like we are calling from initial parent ftn)
        count += (idx == lead) ? solve(digits, idx + 1, 0, sum, lead + 1, m, dp) : 0;
        return dp[idx][tight][sum + 100][lead] = count;
    } // sum + 100 is a buffer if sum becomes negative when subtracting

    private int[] helper(int num) {
        if (num == 0) {
            return new int[1]; // edge case when low = 1, doing low - 1 gives 0
        } // since cannot call log(0), just capture if we pass num = 0 here
        int m = (int) Math.log10(num) + 1;
        int[] digits = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }
}
