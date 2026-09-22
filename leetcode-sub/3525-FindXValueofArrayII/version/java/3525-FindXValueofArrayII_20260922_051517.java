// Last updated: 9/22/2026, 5:15:17 AM
1class SegmentTree {
2
3    private static final int MAXK = 6;
4    private int k;
5    private int n;
6    private int[][] tree;
7
8    public SegmentTree(int[] nums, int k) {
9        this.k = k;
10        this.n = nums.length;
11        int size = 2 << Integer.toBinaryString(n).length();
12        tree = new int[size][MAXK];
13        build(nums, 1, 0, n - 1);
14    }
15
16    private void makeLeaf(int o, int value) {
17        Arrays.fill(tree[o], 0);
18        int r = value % k;
19        tree[o][r] = 1;
20        tree[o][k] = r;
21    }
22
23    private void mergePre(int[] left, int[] right, int[] result) {
24        int mulL = left[k];
25        int mulR = right[k];
26        result[k] = (mulL * mulR) % k;
27
28        for (int x = 0; x < k; x++) {
29            result[x] = left[x];
30        }
31        for (int x = 0; x < k; x++) {
32            result[(mulL * x) % k] += right[x];
33        }
34    }
35
36    private void maintain(int o) {
37        mergePre(tree[o * 2], tree[o * 2 + 1], tree[o]);
38    }
39
40    private void build(int[] nums, int o, int l, int r) {
41        if (l == r) {
42            makeLeaf(o, nums[l]);
43            return;
44        }
45        int m = (l + r) / 2;
46        build(nums, o * 2, l, m);
47        build(nums, o * 2 + 1, m + 1, r);
48        maintain(o);
49    }
50
51    public void update(int o, int l, int r, int index, int value) {
52        if (l == r) {
53            makeLeaf(o, value);
54            return;
55        }
56        int m = (l + r) / 2;
57        if (index <= m) {
58            update(o * 2, l, m, index, value);
59        } else {
60            update(o * 2 + 1, m + 1, r, index, value);
61        }
62        maintain(o);
63    }
64
65    public int[] query(int o, int l, int r, int L, int R) {
66        if (L <= l && r <= R) {
67            return tree[o];
68        }
69
70        int m = (l + r) / 2;
71        if (R <= m) {
72            return query(o * 2, l, m, L, R);
73        }
74        if (L > m) {
75            return query(o * 2 + 1, m + 1, r, L, R);
76        }
77
78        int[] left = query(o * 2, l, m, L, R);
79        int[] right = query(o * 2 + 1, m + 1, r, L, R);
80        int[] result = new int[MAXK];
81        mergePre(left, right, result);
82        return result;
83    }
84}
85
86class Solution {
87
88    public int[] resultArray(int[] nums, int k, int[][] queries) {
89        int n = nums.length;
90        SegmentTree seg = new SegmentTree(nums, k);
91        int[] ans = new int[queries.length];
92
93        for (int i = 0; i < queries.length; i++) {
94            int[] q = queries[i];
95            int index = q[0];
96            int value = q[1];
97            int start = q[2];
98            int x = q[3];
99
100            seg.update(1, 0, n - 1, index, value);
101            int[] pre = seg.query(1, 0, n - 1, start, n - 1);
102            ans[i] = pre[x];
103        }
104
105        return ans;
106    }
107}