// Last updated: 7/29/2026, 11:18:46 PM
1class Solution {
2    public int[] popcountDepth(long[] nums, long[][] queries) {
3        int n = nums.length, count = 0, idx = 0;
4        for (long[] query : queries) {
5            count += query[0] == 1 ? 1 : 0;
6        } // countOnes
7        int[] map = new int[n], res = new int[count];
8        SegmentTreeSum[] trees = new SegmentTreeSum[6];
9        for (int i = 0; i < n; i++) {
10            map[i] = helper(nums[i]);
11        }
12        for (int k = 0; k <= 5; k++) {
13            int[] arr = new int[n];
14            for (int i = 0; i < n; i++) {
15                arr[i] = map[i] == k ? 1 : 0;
16            }
17            trees[k] = new SegmentTreeSum(arr);
18        }
19        for (long[] q : queries) {
20            if ((int) q[0] == 1) {
21                int l = (int) q[1], r = (int) q[2], k = (int) q[3];
22                res[idx++] = trees[k].query(l, r);
23            } 
24            else {
25                int i = (int) q[1], oldDepth = map[i], newDepth = helper(q[2]);
26                if (oldDepth != newDepth) {
27                    trees[oldDepth].update(i, 0);
28                    trees[newDepth].update(i, 1);
29                    map[i] = newDepth;
30                }
31            }
32        }
33        return res;
34    }
35
36    private int helper(long num) {
37        int depth = 0;
38        while (num != 1) {
39            num = Long.bitCount(num);
40            depth++;
41        }
42        return depth;
43    }
44
45    class SegmentTreeSum {
46        int[] tree;
47        int n;
48
49        public SegmentTreeSum(int[] nums) {
50            n = nums.length;
51            tree = new int[4 * n];
52            build(nums, 0, 0, n - 1);
53        }
54
55        private void build(int[] nums, int node, int l, int r) {
56            if (l == r) {
57                tree[node] = nums[l];
58            } else {
59                int mid = l + (r - l) / 2;
60                build(nums, 2 * node + 1, l, mid);
61                build(nums, 2 * node + 2, mid + 1, r);
62                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
63            }
64        }
65
66        public void update(int index, int val) {
67            update(0, 0, n - 1, index, val);
68        }
69
70        private void update(int node, int l, int r, int index, int val) {
71            if (l == r) {
72                tree[node] = val;
73            } else {
74                int mid = l + (r - l) / 2;
75                if (index <= mid) {
76                    update(2 * node + 1, l, mid, index, val);
77                } else {
78                    update(2 * node + 2, mid + 1, r, index, val);
79                }
80                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
81            }
82        }
83
84        public int query(int left, int right) {
85            return query(0, 0, n - 1, left, right);
86        }
87
88        private int query(int node, int l, int r, int left, int right) {
89            if (right < l || r < left) return 0;
90            if (left <= l && r <= right) return tree[node];
91
92            int mid = l + (r - l) / 2;
93            int leftSum = query(2 * node + 1, l, mid, left, right);
94            int rightSum = query(2 * node + 2, mid + 1, r, left, right);
95            return leftSum + rightSum;
96        }
97    }
98}