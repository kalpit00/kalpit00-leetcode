// Last updated: 8/21/2025, 8:13:40 PM
class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length, n = grid[0].length, l = n, r = -1, t = m, b = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                l = Math.min(l, j);
                t = Math.min(t, i);
                r = Math.max(r, j);
                b = Math.max(b, i);
            }
        }
        return (r + 1 - l) * (b + 1 - t);
    }
}