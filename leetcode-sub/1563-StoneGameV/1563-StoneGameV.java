// Last updated: 8/16/2026, 9:23:38 PM
1class Solution {
2    public int stoneGameV(int[] stoneValue) {
3        int n = stoneValue.length;
4        int[][] dp = new int[n][n], max = new int[n][n];
5        for(int i = 0; i < n; i++) {
6            max[i][i] = stoneValue[i];
7        }
8        for(int j = 1; j < n; j++) {
9            int mid = j, sum = stoneValue[j], rightHalf = 0;
10            for(int i = j-1; i >= 0; i--) {
11                sum += stoneValue[i];
12                while((rightHalf + stoneValue[mid]) * 2 <= sum) {
13                    rightHalf += stoneValue[mid--];
14                }
15                dp[i][j] = rightHalf * 2 == sum ? max[i][mid] : (mid == i ? 0 : max[i][mid - 1]);
16                dp[i][j] = Math.max(dp[i][j], mid == j ? 0 : max[j][mid + 1]);
17                max[i][j] = Math.max(max[i][j - 1], dp[i][j] + sum);
18                max[j][i] = Math.max(max[j][i + 1], dp[i][j] + sum);
19            }
20        }
21        return dp[0][n-1];
22    }
23}