// Last updated: 4/12/2025, 6:10:02 PM
class Solution {
    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length, r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        }
        else {
            dfs(board, r, c, m, n);
        }
        return board;
    }
    
    private int countMines(char[][] board, int x, int y, int m, int n) {
        int count = 0;
        for (int[] d : dir) {
            int r = x + d[0], c = y + d[1];
            count += r >= 0 && r < m && c >= 0 && c < n && 
            board[r][c] == 'M' ? 1 : 0;
        }
        return count;
    }
    private void dfs(char[][] board, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') {
            return;
        }
        int mines = countMines(board, x, y, m, n);
        if (mines == 0) {
            board[x][y] = 'B';
            for (int[] d : dir) {
                int r = x + d[0], c = y + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n) {
                    dfs(board, r, c, m, n);
                }
            }
        }
        else {
            board[x][y] = (char) (mines + '0');
        } 
    }
}
