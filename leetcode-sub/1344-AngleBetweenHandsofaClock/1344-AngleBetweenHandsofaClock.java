// Last updated: 6/17/2026, 8:50:02 PM
1class Solution {
2    public double angleClock(int hour, int minutes) {
3        double h = (hour % 12 * 30) + ((double) minutes/60 * 30);
4        double m = minutes * 6;
5        double angle = Math.abs(m - h);
6        return angle > 180 ? 360 - angle : angle;
7    }
8}