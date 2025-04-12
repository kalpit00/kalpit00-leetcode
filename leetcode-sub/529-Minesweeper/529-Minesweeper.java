// Last updated: 4/12/2025, 6:16:54 PM
class Solution {
    int[][] dir = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length, r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } // if clicked cell is a mine, game lost. make it X and return
        else {
            dfs(board, r, c, m, n);
        } // otherwise initiate dfs
        return board;
    }
    
    private int countMines(char[][] board, int x, int y, int m, int n) {
        int count = 0; // simply count 8 directional inbound 'M' cells
        for (int[] d : dir) {
            int r = x + d[0], c = y + d[1];
            count += r >= 0 && r < m && c >= 0 && c < n && 
            board[r][c] == 'M' ? 1 : 0;
        }
        return count;
    }
    private void dfs(char[][] board, int x, int y, int m, int n) {
        // check the 8 adj cells to [x][y], count if they are 'M's
        int mines = countMines(board, x, y, m, n);
        if (mines == 0) { // if none of the 8 adj were mines, reveal it and dfs
            board[x][y] = 'B'; // convert 'E' cell to 'B == revealed'
            for (int[] d : dir) {
                int r = x + d[0], c = y + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'E') {
                    dfs(board, r, c, m, n);
                } // dfs to any unexplored 'E' cells only!
            }
        } 
        else { // otherwise if some of the 8 adj were mines, set that count
            board[x][y] = (char) (mines + '0');
        } 
    }
}
