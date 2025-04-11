// Last updated: 4/10/2025, 11:55:27 PM
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        return count(helper(high)) - count(helper(low - 1));
    }
    private int count(int[] digits) {
        int n = digits.length;
        Integer[][][][] dp = new Integer[n][2][201][n + 1];
        return solve(digits, 0, 1, 0, 0, n, dp);
    }

    private int solve(int[] digits, int idx, int tight, int sum, int lead, int n, Integer[][][][] dp) {
        int len = n - lead;
        if (idx == n) {
            return (len > 0 && len % 2 == 0 && sum == 0) ? 1 : 0;
        }
        if (dp[idx][tight][sum + 100][lead] != null) {
            return dp[idx][tight][sum + 100][lead];
        }
        int limit = tight == 1 ? digits[idx] : 9, count = 0;
        for (int i = (lead == idx ? 1 : 0); i <= limit; i++) { 
            int isFirstHalf = (idx - lead) < len / 2 ? 1 : -1;
            int newTight = tight == 1 && i == limit ? 1 : 0; 
            count += solve(digits, idx + 1, newTight, sum + isFirstHalf * i, lead, n, dp);
        }
        if (idx == lead) {
            int newTight = tight == 1 && 0 == limit ? 1 : 0; 
            count += solve(digits, idx + 1, newTight, sum, lead + 1, n, dp);
        }
        return dp[idx][tight][sum + 100][lead] = count;
    }

    private int[] helper(int num) {
        if (num == 0) {
            return new int[1];
        }
        int m = (int) Math.log10(num) + 1;
        int[] digits = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }
}
