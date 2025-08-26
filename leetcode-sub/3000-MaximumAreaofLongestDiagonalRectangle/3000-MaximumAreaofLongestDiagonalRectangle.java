// Last updated: 8/25/2025, 8:44:24 PM
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiaSq = 0, maxArea = 0;
        for (int[] dim : dimensions) {
            int l = dim[0], w = dim[1];
            int diaSq = l * l + w * w, area = l * w;
            if (diaSq > maxDiaSq) {
                maxDiaSq = diaSq;
                maxArea = area;
            } else if (diaSq == maxDiaSq) {
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}