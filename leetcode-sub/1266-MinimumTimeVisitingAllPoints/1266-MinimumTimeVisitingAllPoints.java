// Last updated: 1/11/2026, 8:16:22 PM
1class Solution {
2    public int minTimeToVisitAllPoints(int[][] points) {
3        int total = 0;
4        for (int i = 0; i < points.length - 1; i++) {
5            total += chebyshev(points[i], points[i+1]);
6        }
7        return total;
8    }
9    
10    public int chebyshev(int[] p1, int[] p2) {
11        // greedy strategy, go diagonally first as much as possible
12        // the diagonal movement is bounded by min(xDiff, yDiff)
13        // the remaining steps is the max(xDiff, yDiff) - min(xDiff, yDiff)
14        // adding them, the min term gets cancelled, and left with chebyshev distance formula
15        return Math.max(Math.abs(p1[0] - p2[0]), Math.abs(p1[1] - p2[1]));
16    }
17}