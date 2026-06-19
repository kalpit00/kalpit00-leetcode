// Last updated: 6/19/2026, 1:52:54 AM
1class Solution {
2    public int largestAltitude(int[] gain) {
3        int max = 0, sum = 0;
4        for (int g : gain) {
5            sum += g;
6            max = Math.max(max, sum);
7        }
8        return max;
9    }
10}