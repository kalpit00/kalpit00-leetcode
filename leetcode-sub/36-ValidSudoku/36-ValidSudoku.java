// Last updated: 8/29/2025, 9:25:28 PM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length, k = (int) Math.sqrt(n);
        boolean[][] rows = new boolean[n][10], cols = new boolean[n][10];
        boolean[][][] boxes = new boolean[k][k][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (rows[i][c - '0']) {
                    return false;
                }
                if (cols[j][c - '0']) {
                    return false;
                }
                if (boxes[i/k][j/k][c - '0']) {
                    return false;
                }
                rows[i][c - '0'] = true;
                cols[j][c - '0'] = true;
                boxes[i/k][j/k][c - '0'] = true;
            }
        }
        return true;
    }
}
