// Last updated: 1/16/2026, 8:32:38 PM
1class Solution {
2    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
3        int n = topRight.length;
4        long max = 0;
5        for (int i = 0; i < n; i++) {
6            for (int j = i + 1; j < n; j++) {
7                int maxStartX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
8                int minEndX = Math.min(topRight[i][0], topRight[j][0]);
9                int maxStartY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
10                int minEndY = Math.min(topRight[i][1], topRight[j][1]);
11                // only if intersecting rectangle
12                if (minEndX > maxStartX && minEndY > maxStartY) {
13// we want square, so find which side is smaller and square to its area
14                    long length = minEndX - maxStartX;
15                    long width = minEndY - maxStartY;
16                    long side = Math.min(length, width);
17                    long area = side * side;
18                    max = Math.max(max, area);
19                }
20            }
21        }
22        return max;
23    }
24}