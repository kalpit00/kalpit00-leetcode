// Last updated: 9/7/2025, 8:55:38 PM
class Solution {
    public boolean checkStraightLine(int[][] p) {
        int n = p.length;
        for (int i = 1; i < n - 1; i++) {
            int x = p[i][0], y = p[i][1], x1 = p[i - 1][0], y1 = p[i - 1][1],
            x2 = p[i + 1][0], y2 = p[i + 1][1]; // y2-y/x2-x = y-y1/x-x1
            if ((y2 - y) * (x - x1) != (y - y1) * (x2 - x)) {
                return false;
            }
        }
        return true;
    }
}