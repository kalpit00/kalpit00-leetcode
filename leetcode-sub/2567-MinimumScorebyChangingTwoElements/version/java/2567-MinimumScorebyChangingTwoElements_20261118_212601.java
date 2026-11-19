// Last updated: 11/18/2026, 9:26:01 PM
1class Solution {
2    public int minimizeSum(int[] A) {
3        int n = A.length;
4        Arrays.sort(A);
5        return Math.min(Math.min(A[n - 1] - A[2], A[n - 3] - A[0]), A[n - 2] - A[1]);
6    }
7}