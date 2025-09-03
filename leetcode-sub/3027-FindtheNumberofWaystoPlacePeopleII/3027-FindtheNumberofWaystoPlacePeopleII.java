// Last updated: 9/2/2025, 10:01:12 PM
class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0, n = points.length;
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? 
        Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; i++) {
            int y = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if (points[i][1] >= points[j][1] && points[j][1] > y) {
                    count++;
                    y = points[j][1];
                }
            }
        }
        return count;
    }
}