// Last updated: 12/7/2025, 7:04:53 PM
1class Solution {
2    public int countTriples(int n) {
3        int count = 0;
4        for (int i = 1; i <= n; i++) {
5            for (int j = i + 1; j <= n; j++) {
6                int k = i * i + j * j, sqrt = (int) Math.sqrt(k);
7                count += sqrt * sqrt == k && sqrt <= n ? 2 : 0;                
8            }
9        }
10        return count;
11    }
12}