// Last updated: 5/20/2026, 1:53:00 AM
1class Solution {
2    public int[] findThePrefixCommonArray(int[] A, int[] B) {
3        int n = A.length;
4        long maskA = 0, maskB = 0;
5        int[] res = new int[n];
6        for (int i = 0; i < n; i++) {
7            maskA |= (1L << A[i]);
8            maskB |= (1L << B[i]);
9            res[i] = Long.bitCount(maskA & maskB);
10        }
11        return res;
12    }
13}