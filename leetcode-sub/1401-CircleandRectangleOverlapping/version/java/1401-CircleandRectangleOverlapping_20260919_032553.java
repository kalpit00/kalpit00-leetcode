// Last updated: 9/19/2026, 3:25:53 AM
1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
3        for (int i = y1; i <= y2; i++) {
4            for (int j = x1; j <= x2; j++) {
5                if (helper(j, i, radius, xCenter, yCenter)) {
6                    return true;
7                }
8            }
9        }
10        return false;
11    }
12    private boolean helper(int x, int y, int r, int h, int k) {
13        return (x - h) * (x - h) + (y - k) * (y - k) <= r * r;
14    }
15}