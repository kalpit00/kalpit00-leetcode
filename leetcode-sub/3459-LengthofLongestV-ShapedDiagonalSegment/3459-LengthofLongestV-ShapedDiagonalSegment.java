// Last updated: 8/26/2025, 9:31:15 PM
class Solution {
    int[][] dir = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}};    
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length, n = grid[0].length, max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        max = Math.max(max, dfs(grid, i, j, k, 1, false));
                    }
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j, int k, int prev, boolean flag) {
        int m = grid.length, n = grid[0].length;        
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != prev) {
            return 0;
        }
        int next = prev == 2 ? 0 : 2, max = 1;
        max = Math.max(max, 1 + dfs(grid, i + dir[k][0], j + dir[k][1],
        k, next, flag));
        if (!flag) {
            for (int d = 0; d < 4; d++) {
                if (d != k && isClockwiseTurn(k, d)) {
                    int r = i + dir[d][0], c = j + dir[d][1];
                    max = Math.max(max, 1 + dfs(grid, r, c, d, next, true));
                }
            }
        }
        return max;
    }
    
    private boolean isClockwiseTurn(int fromDir, int toDir) {
        // Define clockwise turns: BR->BL, BL->TL, TL->TR, TR->BR
        // Direction indices: BR=0, TL=1, TR=2, BL=3
        return (fromDir == 0 && toDir == 3) || // BR -> BL
               (fromDir == 3 && toDir == 1) || // BL -> TL  
               (fromDir == 1 && toDir == 2) || // TL -> TR
               (fromDir == 2 && toDir == 0);   // TR -> BR
    }
}