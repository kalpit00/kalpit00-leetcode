// Last updated: 3/26/2026, 10:59:27 PM
1class Solution {
2    public boolean areSimilar(int[][] mat, int k) {
3        int m = mat.length, n = mat[0].length;
4        k %= n;
5        for (int i = 0; i < m; i++) {
6            for (int j = 0; j < n; j++) {
7                if (mat[i][j] != mat[i][(j + k) % n]) {
8                    return false;
9                }
10            }
11        }
12        return true;
13    }
14}