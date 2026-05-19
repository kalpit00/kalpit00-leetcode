// Last updated: 5/19/2026, 6:48:20 AM
1class Solution {
2    public int oddCells(int m, int n, int[][] indices) {
3        int[] rowSum = new int[m], colSum = new int[n];
4        for (int[] arr : indices) {
5            int i = arr[0], j = arr[1];
6            rowSum[i]++;
7            colSum[j]++;
8        }
9        int count = 0;
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                count += (rowSum[i] + colSum[j]) % 2 == 1 ? 1 : 0;
13            }
14        }
15        return count;
16    }
17}