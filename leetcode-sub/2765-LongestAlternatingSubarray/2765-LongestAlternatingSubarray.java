// Last updated: 1/1/2026, 1:09:05 AM
1class Solution {
2    public int alternatingSubarray(int[] A) {
3        int n = A.length, res = 0, j = 0;
4        for (int i = 0; i < n; i = Math.max(i + 1, j - 1))
5            for (j = i + 1; j < n && A[j] == A[i] + (j - i) % 2; ++j)
6                res = Math.max(res, j - i + 1);
7        return res > 1 ? res : -1;
8    }
9}