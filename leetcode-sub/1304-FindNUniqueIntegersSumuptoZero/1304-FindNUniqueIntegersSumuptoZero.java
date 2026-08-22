// Last updated: 8/21/2026, 11:50:00 PM
1class Solution {
2    public int[] sumZero(int n) {
3        int sum = 0;
4        int[] res = new int[n];
5        for (int i = 0; i < n / 2; i++) {
6            res[i] = i + 1;
7            res[n - i - 1] = -(i + 1);
8        }
9        // res[n / 2] = 0; // redudant as int[] have 0s by default
10        return res;
11    }
12}