// Last updated: 1/13/2026, 7:47:31 PM
1class SegmentTree {
2
3    private int[] count;
4    private int[] covered;
5    private int[] xs;
6    private int n;
7
8    public SegmentTree(int[] xs_) {
9        xs = xs_;
10        n = xs.length - 1;
11        count = new int[4 * n];
12        covered = new int[4 * n];
13    }
14
15    private void modify(
16        int qleft,
17        int qright,
18        int qval,
19        int left,
20        int right,
21        int pos
22    ) {
23        if (xs[right + 1] <= qleft || xs[left] >= qright) {
24            return;
25        }
26        if (qleft <= xs[left] && xs[right + 1] <= qright) {
27            count[pos] += qval;
28        } else {
29            int mid = (left + right) / 2;
30            modify(qleft, qright, qval, left, mid, pos * 2 + 1);
31            modify(qleft, qright, qval, mid + 1, right, pos * 2 + 2);
32        }
33
34        if (count[pos] > 0) {
35            covered[pos] = xs[right + 1] - xs[left];
36        } else {
37            if (left == right) {
38                covered[pos] = 0;
39            } else {
40                covered[pos] = covered[pos * 2 + 1] + covered[pos * 2 + 2];
41            }
42        }
43    }
44
45    public void update(int qleft, int qright, int qval) {
46        modify(qleft, qright, qval, 0, n - 1, 0);
47    }
48
49    public int query() {
50        return covered[0];
51    }
52}
53
54class Solution {
55
56    public double separateSquares(int[][] squares) {
57        // save events: (y-coordinate, type, left boundary, right boundary)
58        List<int[]> events = new ArrayList<>();
59        Set<Integer> xsSet = new TreeSet<>();
60
61        for (int[] sq : squares) {
62            int x = sq[0];
63            int y = sq[1];
64            int l = sq[2];
65            int xr = x + l;
66            events.add(new int[] { y, 1, x, xr });
67            events.add(new int[] { y + l, -1, x, xr });
68            xsSet.add(x);
69            xsSet.add(xr);
70        }
71
72        // sort events by y-coordinate
73        events.sort((a, b) -> Integer.compare(a[0], b[0]));
74        // discrete coordinates
75        int[] xs = xsSet.stream().mapToInt(i -> i).toArray();
76        // initialize the segment tree
77        SegmentTree segTree = new SegmentTree(xs);
78
79        List<Long> psum = new ArrayList<>();
80        List<Integer> widths = new ArrayList<>();
81        Long totalArea = 0L;
82        int prev = events.get(0)[0];
83
84        // scan: calculate total area and record intermediate states
85        for (int[] event : events) {
86            int y = event[0];
87            int delta = event[1];
88            int xl = event[2];
89            int xr = event[3];
90            int len = segTree.query();
91            totalArea += (long) len * (y - prev);
92            segTree.update(xl, xr, delta);
93            // record prefix sums and widths
94            psum.add(totalArea);
95            widths.add(segTree.query());
96            prev = y;
97        }
98
99        // calculate the target area (half rounded up)
100        long target = (long) (totalArea + 1) / 2;
101        // binary search
102        int i = binarySearch(psum, target);
103        double area = psum.get(i);
104        // get the corresponding area, width, and height
105        int width = widths.get(i);
106        int height = events.get(i)[0];
107
108        return height + (totalArea - area * 2) / (width * 2.0);
109    }
110
111    private int binarySearch(List<Long> list, long target) {
112        int left = 0;
113        int right = list.size() - 1;
114        int result = 0;
115
116        while (left <= right) {
117            int mid = left + (right - left) / 2;
118            if (list.get(mid) < target) {
119                result = mid;
120                left = mid + 1;
121            } else {
122                right = mid - 1;
123            }
124        }
125        return result;
126    }
127}