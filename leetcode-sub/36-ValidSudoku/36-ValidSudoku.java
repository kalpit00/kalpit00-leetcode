// Last updated: 8/29/2025, 9:26:59 PM
class Solution {
    public boolean isValidSudoku(char[][] board) {
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
                if (rows[i][idx]) {
                    return false;
                }
                if (cols[j][idx]) {
                    return false;
                }
                if (boxes[i/k][j/k][idx]) {
                    return false;
                }
                rows[i][idx] = true;
                cols[j][idx] = true;
                boxes[i/k][j/k][idx] = true;
            }
        }
        return true;
    }
}
