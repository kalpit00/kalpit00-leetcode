// Last updated: 7/21/2025, 2:07:23 PM
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 1001, sum = 0;
        int[] count = new int[n];
        for (int[] trip : trips) {
            int start = trip[1], end = trip[2], val = trip[0];
            count[start] += val;
            count[end] -= val;           
        }
        for (int i = 0; i < n; i++) {
            sum += count[i];
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}