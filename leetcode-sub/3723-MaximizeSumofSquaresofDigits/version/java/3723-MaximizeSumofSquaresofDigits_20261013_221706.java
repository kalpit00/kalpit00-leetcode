// Last updated: 10/13/2026, 10:17:06 PM
1class Solution {
2    public String maxSumOfSquares(int num, int sum) {
3        if (sum > 9 * num) return "";
4        StringBuilder sb = new StringBuilder();
5        for (int i = 0; i < num; i++) {
6            int d = Math.min(9, sum);
7            sb.append(d);
8            sum -= d;
9        }
10        return sum != 0 ? "" : sb.toString();
11    }
12}