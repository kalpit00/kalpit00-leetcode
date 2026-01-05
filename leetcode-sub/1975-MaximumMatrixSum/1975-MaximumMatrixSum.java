// Last updated: 1/4/2026, 8:14:30 PM
1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3        long sum = 0;
4        int min = Integer.MAX_VALUE, count = 0;
5        for (int[] r : matrix) {
6            for (int num : r) {
7                count += num < 0 ? 1 : 0;
8                num = num < 0 ? -num : num;
9                sum += num;
10                min = Math.min(min, num);
11            }
12        }
13        sum -= count % 2 == 1 ? 2 * min : 0;
14        return sum;
15    }
16}