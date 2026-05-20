// Last updated: 5/20/2026, 1:50:14 AM
1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int n = A.length, count = 0;
4        long mask = 0;
5        int[] res = new int[n];
6        for (int i = 0; i < n; i++) {
7            if ((mask & (1L << A[i])) != 0) {
8                count++;
9            }
10            mask |= (1L << A[i]);
11            if ((mask & (1L << B[i])) != 0) {
12                count++;
13            }
14            mask |= (1L << B[i]);
15            res[i] = count;
16        }
17        return res;
18    }
19}