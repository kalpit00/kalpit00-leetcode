// Last updated: 1/12/2026, 7:22:55 PM
1class Solution {
2    public double separateSquares(int[][] squares) {
3        double max = 0, sum = 0, ans = -1;
4        for (int[] square : squares) {
5            int y = square[1], l = square[2];
6            sum += (double) l * l;
7            max = Math.max(max, (double) (y + l));
8        }
9        double start = 0, end = max, eps = 1e-5;
10        while (Math.abs(end - start) >= eps) {
11            double mid = start + (end - start) / 2;
12            if (helper(mid, squares, sum)) {
13                end = mid;
14                ans = mid;
15            }
16            else {
17                start = mid;
18            }
19        }
20        return ans;
21    }
22
23    private boolean helper(double mid, int[][] squares, double sum) {
24        double area = 0;
25        for (int[] square : squares) {
26            int y = square[1], l = square[2];
27            if (y < mid) {
28                area += (double) l * Math.min(mid - y, (double) l);
29            }
30        }
31        return area >= sum / 2;
32    }
33}