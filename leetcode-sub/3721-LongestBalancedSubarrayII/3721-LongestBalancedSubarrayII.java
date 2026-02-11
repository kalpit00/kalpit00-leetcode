// Last updated: 2/10/2026, 7:02:02 PM
1class LazyTag {
2
3    int toAdd;
4
5    LazyTag() {
6        this.toAdd = 0;
7    }
8
9    LazyTag add(LazyTag other) {
10        this.toAdd += other.toAdd;
11        return this;
12    }
13
14    boolean hasTag() {
15        return this.toAdd != 0;
16    }
17
18    void clear() {
19        this.toAdd = 0;
20    }
21}
22
23class SegmentTreeNode {
24
25    int minValue;
26    int maxValue;
27    LazyTag lazyTag;
28
29    SegmentTreeNode() {
30        this.minValue = 0;
31        this.maxValue = 0;
32        this.lazyTag = new LazyTag();
33    }
34}
35
36class SegmentTree {
37
38    private int n;
39    private SegmentTreeNode[] tree;
40
41    SegmentTree(int[] data) {
42        this.n = data.length;
43        this.tree = new SegmentTreeNode[this.n * 4 + 1];
44        for (int i = 0; i < tree.length; i++) {
45            tree[i] = new SegmentTreeNode();
46        }
47        build(data, 1, this.n, 1);
48    }
49
50    void add(int l, int r, int val) {
51        LazyTag tag = new LazyTag();
52        tag.toAdd = val;
53        update(l, r, tag, 1, this.n, 1);
54    }
55
56    int findLast(int start, int val) {
57        if (start > this.n) {
58            return -1;
59        }
60        return find(start, this.n, val, 1, this.n, 1);
61    }
62
63    private void applyTag(int i, LazyTag tag) {
64        tree[i].minValue += tag.toAdd;
65        tree[i].maxValue += tag.toAdd;
66        tree[i].lazyTag.add(tag);
67    }
68
69    private void pushdown(int i) {
70        if (tree[i].lazyTag.hasTag()) {
71            LazyTag tag = new LazyTag();
72            tag.toAdd = tree[i].lazyTag.toAdd;
73            applyTag(i << 1, tag);
74            applyTag((i << 1) | 1, tag);
75            tree[i].lazyTag.clear();
76        }
77    }
78
79    private void pushup(int i) {
80        tree[i].minValue = Math.min(
81            tree[i << 1].minValue,
82            tree[(i << 1) | 1].minValue
83        );
84        tree[i].maxValue = Math.max(
85            tree[i << 1].maxValue,
86            tree[(i << 1) | 1].maxValue
87        );
88    }
89
90    private void build(int[] data, int l, int r, int i) {
91        if (l == r) {
92            tree[i].minValue = tree[i].maxValue = data[l - 1];
93            return;
94        }
95
96        int mid = l + ((r - l) >> 1);
97        build(data, l, mid, i << 1);
98        build(data, mid + 1, r, (i << 1) | 1);
99        pushup(i);
100    }
101
102    private void update(
103        int targetL,
104        int targetR,
105        LazyTag tag,
106        int l,
107        int r,
108        int i
109    ) {
110        if (targetL <= l && r <= targetR) {
111            applyTag(i, tag);
112            return;
113        }
114
115        pushdown(i);
116        int mid = l + ((r - l) >> 1);
117        if (targetL <= mid) update(targetL, targetR, tag, l, mid, i << 1);
118        if (targetR > mid) update(
119            targetL,
120            targetR,
121            tag,
122            mid + 1,
123            r,
124            (i << 1) | 1
125        );
126        pushup(i);
127    }
128
129    private int find(int targetL, int targetR, int val, int l, int r, int i) {
130        if (tree[i].minValue > val || tree[i].maxValue < val) {
131            return -1;
132        }
133
134        if (l == r) {
135            return l;
136        }
137
138        pushdown(i);
139        int mid = l + ((r - l) >> 1);
140
141        if (targetR >= mid + 1) {
142            int res = find(targetL, targetR, val, mid + 1, r, (i << 1) | 1);
143            if (res != -1) return res;
144        }
145
146        if (l <= targetR && mid >= targetL) {
147            return find(targetL, targetR, val, l, mid, i << 1);
148        }
149
150        return -1;
151    }
152}
153
154class Solution {
155
156    public int longestBalanced(int[] nums) {
157        Map<Integer, Queue<Integer>> occurrences = new HashMap<>();
158
159        int len = 0;
160        int[] prefixSum = new int[nums.length];
161        prefixSum[0] = sgn(nums[0]);
162        occurrences.computeIfAbsent(nums[0], k -> new LinkedList<>()).add(1);
163
164        for (int i = 1; i < nums.length; i++) {
165            prefixSum[i] = prefixSum[i - 1];
166            Queue<Integer> occ = occurrences.computeIfAbsent(nums[i], k ->
167                new LinkedList<>()
168            );
169            if (occ.isEmpty()) {
170                prefixSum[i] += sgn(nums[i]);
171            }
172            occ.add(i + 1);
173        }
174
175        SegmentTree seg = new SegmentTree(prefixSum);
176
177        for (int i = 0; i < nums.length; i++) {
178            len = Math.max(len, seg.findLast(i + len, 0) - i);
179
180            int nextPos = nums.length + 1;
181            occurrences.get(nums[i]).poll();
182            if (!occurrences.get(nums[i]).isEmpty()) {
183                nextPos = occurrences.get(nums[i]).peek();
184            }
185
186            seg.add(i + 1, nextPos - 1, -sgn(nums[i]));
187        }
188
189        return len;
190    }
191
192    private int sgn(int x) {
193        return (x % 2) == 0 ? 1 : -1;
194    }
195}