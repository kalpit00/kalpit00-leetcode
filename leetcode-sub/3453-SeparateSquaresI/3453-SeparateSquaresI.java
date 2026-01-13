// Last updated: 1/12/2026, 7:17:18 PM
1class Solution {
2
3    public double separateSquares(int[][] squares) {
4        long totalArea = 0;
5        List<int[]> events = new ArrayList<>();
6
7        for (int[] sq : squares) {
8            int y = sq[1];
9            int l = sq[2];
10            totalArea += (long) l * l;
11            events.add(new int[] { y, l, 1 });
12            events.add(new int[] { y + l, l, -1 });
13        }
14
15        // sort by y-coordinate
16        events.sort((a, b) -> Integer.compare(a[0], b[0]));
17        double coveredWidth = 0; // sum of all bottom edges under the current scanning line
18        double currArea = 0; // current cumulative area
19        double prevHeight = 0; // height of the previous scanning line
20
21        for (int[] event : events) {
22            int y = event[0];
23            int l = event[1];
24            int delta = event[2];
25
26            int diff = y - (int) prevHeight;
27            // additional area between two scanning lines
28            double area = coveredWidth * diff;
29            // if this part of the area exceeds more than half of the total area
30            if (2L * (currArea + area) >= totalArea) {
31                return (
32                    prevHeight +
33                    (totalArea - 2.0 * currArea) / (2.0 * coveredWidth)
34                );
35            }
36            // update width: add width at the start event, subtract width at the end event
37            coveredWidth += delta * l;
38            currArea += area;
39            prevHeight = y;
40        }
41
42        return 0.0;
43    }
44}