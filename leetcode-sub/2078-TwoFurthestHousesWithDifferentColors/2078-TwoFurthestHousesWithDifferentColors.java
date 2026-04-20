// Last updated: 4/20/2026, 12:20:46 AM
1class Solution {
2    public int maxDistance(int[] colors) {
3        int n = colors.length, i = 0, j = n - 1;
4        while (colors[0] == colors[j]) {
5            j--;
6        }
7        while (colors[n - 1] == colors[i]) {
8            i++;
9        }
10        return Math.max(n - 1 - i, j);
11    }
12}