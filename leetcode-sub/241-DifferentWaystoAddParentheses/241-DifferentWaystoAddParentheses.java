// Last updated: 6/11/2025, 1:54:35 PM
class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        int m = s.length();
        List<Integer>[][] dp = new List[m][m];
        return solve(0, m - 1, s.toCharArray(), dp);
    }

    private List<Integer> solve(int i, int j, char[] s, 
    List<Integer>[][] dp) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        List<Integer> res = new ArrayList<>();
        boolean isNumber = true;
        for (int k = i; k <= j; k++) {
            if (s[k] == '+' || s[k] == '-' || s[k] == '*') {
                isNumber = false;
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
        if (isNumber) {
            int num = 0;
            for (int k = i; k <= j; k++) {
                num = num * 10 + (s[k] - '0');
            }
            res.add(num);
        }
        return dp[i][j] = res;
    }
}
