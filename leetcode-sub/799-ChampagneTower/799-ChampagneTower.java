// Last updated: 4/28/2025, 3:15:28 PM
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] prev = new double[102], curr = new double[102];
        prev[0] = (double) poured;
        for (int i = 1; i <= query_row; i++) {
            double n = prev[0];
            curr[0] = Math.max(0.0, (n - 1) / 2); 
            for (int j = 1; j < i; j++) {
                double n1 = prev[j - 1], n2 = prev[j];
                double mid = Math.max(0.0, (n1 - 1) / 2) + Math.max(0.0, (n2 - 1) / 2);
                curr[j] = mid;
            }
            curr[i] = curr[0];
            System.arraycopy(curr, 0, prev, 0, i + 1);
        }
        return Math.min(1, prev[query_glass]);
    }
}