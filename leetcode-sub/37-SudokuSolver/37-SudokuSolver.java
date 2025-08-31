// Last updated: 8/30/2025, 9:37:27 PM
class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length, k = (int) Math.sqrt(n);
        boolean[][] rows = new boolean[n][n], cols = new boolean[n][n];
        boolean[][][] boxes = new boolean[k][k][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int idx = c - '1';
                rows[i][idx] = true;
                cols[j][idx] = true;
                boxes[i/k][j/k][idx] = true;
            }
        }
        backtrack(board, rows, cols, boxes, n, k);
    }
    private boolean backtrack(char[][] board, boolean[][] rows, 
    boolean[][] cols, boolean[][][] boxes, int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (int c = 0; c < 9; c++) {
                        if (!rows[i][c] && !cols[j][c] &&
                        !boxes[i/k][j/k][c]) {
                            board[i][j] = (char) (c + '1');
                            rows[i][c] = true;
                            cols[j][c] = true;
                            boxes[i/k][j/k][c] = true;
                            if (backtrack(board, rows, cols, boxes, n, k)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                                rows[i][c] = false;
                                cols[j][c] = false;
                                boxes[i/k][j/k][c] = false;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}