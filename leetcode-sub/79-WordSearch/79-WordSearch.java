// Last updated: 5/16/2025, 9:45:00 PM
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length, r = 0, c = 0, count = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                } // count total empty cells
                else if (grid[i][j] == 1) { // src cell coordinates
                    r = i;
                    c = j;
                }
            }
        }
        return backtrack(grid, r, c, m, n, count);
    }
    private int backtrack(int[][] grid, int r, int c, int m, int n, 
    int count) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] < 0) {
            return 0;
        }
        if (grid[r][c] == 2) { // on dest count way if all empty cells visited
            return count == 0 ? 1 : 0; // same as rotten oranges idea!
        } // if count == 0 means valid Hamiltonian Path!!
        grid[r][c] = -2; // mark cell visited!
        count--; // walk the current empty cell, dfs, then backtrack later
        int res = 0;
        res += backtrack(grid, r + 1, c, m, n, count);
        res += backtrack(grid, r - 1, c, m, n, count);
        res += backtrack(grid, r, c + 1, m, n, count);
        res += backtrack(grid, r, c - 1, m, n, count);
        grid[r][c] = 0; // restore it back to empty cell == backtracking!
        count++; // also count this empty cell back!
        return res;
    }
}