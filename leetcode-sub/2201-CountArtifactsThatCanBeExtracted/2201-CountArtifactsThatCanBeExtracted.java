// Last updated: 8/10/2025, 11:27:41 PM
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] grid = new boolean[n][n];
        for (int[] d : dig) {
            int r = d[0], c = d[1];
            grid[r][c] = true;
        }
        int count = 0;
        for (int[] d : artifacts) {
            int r1 = d[0], c1 = d[1], r2 = d[2], c2 = d[3];
            boolean flag = true;
            outer:
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (!grid[i][j]) {
                        flag = false;
                        break outer;
                    }
                }
            }
            count += flag ? 1 : 0;
        }
        return count;
    }
}