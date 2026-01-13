// Last updated: 1/12/2026, 7:17:32 PM
1class Solution {
2
3    public double separateSquares(int[][] squares) {
4        double max_y = 0;
5        double total_area = 0;
6        for (int[] sq : squares) {
7            int y = sq[1];
8            int l = sq[2];
9            total_area += (double) l * l;
10            max_y = Math.max(max_y, (double) (y + l));
11        }
12
13        double lo = 0;
14        double hi = max_y;
15        double eps = 1e-5;
16        while (Math.abs(hi - lo) > eps) {
17            double mid = (hi + lo) / 2;
18            if (check(mid, squares, total_area)) {
19                hi = mid;
20            } else {
21                lo = mid;
22            }
23        }
24
25        return hi;
26    }
27
28    private Boolean check(double limit_y, int[][] squares, double total_area) {
29        double area = 0;
30        for (int[] sq : squares) {
31            int y = sq[1];
32            int l = sq[2];
33            if (y < limit_y) {
34                area += (double) l * Math.min(limit_y - y, (double) l);
35            }
36        }
37        return area >= total_area / 2;
38    }
39}