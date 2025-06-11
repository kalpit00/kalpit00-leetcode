// Last updated: 6/11/2025, 2:24:00 PM
class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        int m = s.length();
        List<Integer>[][] dp = new List[m][m];
        return solve(0, m - 1, s.toCharArray(), dp);
    }

    private List<Integer> solve(int i, int j, char[] s, 
    List<Integer>[][] dp) {
        List<Integer> res = new ArrayList<>();
        if (i == j && Character.isDigit(s[i])) { 
            res.add(s[i] - '0'); // j - i == 0 : single digit number
            return res;
        }
        if (j - i == 1 && Character.isDigit(s[i]) && Character.isDigit(s[j])) {
            res.add(10 * (s[i] - '0') + (s[j] - '0')); // two digit number
            return res;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        for (int k = i; k <= j; k++) {
            if (s[k] == '+' || s[k] == '-' || s[k] == '*') {
                List<Integer> left = solve(i, k - 1, s, dp);
                List<Integer> right = solve(k + 1, j, s, dp);
                for (int a : left) {
                    for (int b : right) {
                        if (s[k] == '+') res.add(a + b);
                        else if (s[k] == '-') res.add(a - b);
                        else if (s[k] == '*') res.add(a * b);
                    }
                }
            }
        }
        return dp[i][j] = res;
    }
}
