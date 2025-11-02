// Last updated: 11/1/2025, 11:26:33 PM
class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        char[][] grid = new char[m][n];
        int count = m * n - guards.length - walls.length;
        for (int[] wall : walls) {
            int x = wall[0], y = wall[1];
            grid[x][y] = 'W';
        }
        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];
            grid[x][y] = 'G';
        }
        for (int[] cell : guards) {
            for (int[] d : dir) {
                int x = cell[0] + d[0], y = cell[1] + d[1];
                while (x >= 0 && x < m && y >= 0 && y < n && 
                grid[x][y] != 'G' && grid[x][y] != 'W') {
                    if (grid[x][y] != 'P') {
                        count--;
                    }
                    grid[x][y] = 'P';
                    x += d[0];
                    y += d[1];
                }
            }
        }
        return count;
    }
}
