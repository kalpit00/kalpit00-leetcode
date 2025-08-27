// Last updated: 8/27/2025, 1:51:21 AM
class Solution {
    // BR : [1, 1], TL : [-1, -1], TR : [-1, 1], BL : [1, -1]
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
        int next = prev == 2 ? 0 : 2;
        int max = 1 + dfs(grid, i + dir[k][0], j + dir[k][1], k, next, flag);
        if (!flag) { // if not clockwise rotated yet
            // clockwise turns: BR->BL, BL->TL, TL->TR, TR->BR
            // BR=0, TL=1, TR=2, BL=3        
            int d = k == 0 ? 3 : k == 3 ? 1 : k == 1 ? 2 : 0;
            int r = i + dir[d][0], c = j + dir[d][1];
            max = Math.max(max, 1 + dfs(grid, r, c, d, next, true));
        }
        return max;
    } 
}