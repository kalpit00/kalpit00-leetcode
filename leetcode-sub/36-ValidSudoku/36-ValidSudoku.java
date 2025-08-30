// Last updated: 8/29/2025, 9:20:13 PM
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length, k = (int) Math.sqrt(n);
        Set<Character>[] rows = new HashSet[n], cols = new HashSet[n];
        Set<Character>[][] boxes = new HashSet[k][k];
        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                boxes[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (rows[i].contains(c)) {
                    return false;
                }
                if (cols[j].contains(c)) {
                    return false;
                }
                if (boxes[i/k][j/k].contains(c)) {
                    return false;
                }
                rows[i].add(c);
                cols[j].add(c);
                boxes[i/k][j/k].add(c);
            }
        }
        return true;
    }
}
