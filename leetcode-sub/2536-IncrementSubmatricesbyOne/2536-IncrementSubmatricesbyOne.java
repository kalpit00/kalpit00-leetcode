// Last updated: 11/13/2025, 7:11:00 PM
class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[2]; i++) {
                for (int j = query[1]; j <= query[3]; j++) {
                    mat[i][j]++;
                }
            }
        }
        return mat;
    }
}