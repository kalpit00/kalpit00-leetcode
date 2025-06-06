// Last updated: 6/6/2025, 1:13:30 PM
class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int count = 0, prev = -1;
        for (int[] point : points) {
            if (point[0] > prev) {
                count++;
                prev = point[0] + w;
            }
        }
        return count;
    }
}