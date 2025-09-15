// Last updated: 9/15/2025, 1:26:50 AM
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (helper(j, i, radius, xCenter, yCenter)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(int x, int y, int r, int h, int k) {
        return (x - h) * (x - h) + (y - k) * (y - k) <= r * r;
    }
}