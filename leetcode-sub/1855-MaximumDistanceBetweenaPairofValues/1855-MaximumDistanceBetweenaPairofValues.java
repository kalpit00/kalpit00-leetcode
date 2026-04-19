// Last updated: 4/18/2026, 8:23:02 PM
1class Solution {
2    public int maxDistance(int[] A, int[] B) {
3        int i, j;
4        for (i = 0, j = 0; i < A.length && j < B.length; j++)
5            if (A[i] > B[j])
6                i++;
7        return Math.max(0, j - i - 1);
8    }
9}