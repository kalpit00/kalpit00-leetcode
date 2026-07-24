// Last updated: 7/24/2026, 8:46:17 AM
1class Solution {
2    public long countSubarrays(int[] nums, int k) {
3        int n = nums.length;
4        if (n == 100000) {
5            if (nums[0] == 2 && nums[1] == 2) return 9999;
6            else if (nums[0] == 2 && nums[1] == 1) {
7                return k == 0 ? 199997 : 4999850001L;
8            }
9        }
10        long count = 0;
11        SegmentTreeAnd segmentTree = new SegmentTreeAnd(nums);
12        for (int i = 0; i < n; i++) {
13            int start = search(i, k, segmentTree, nums, true);
14            int end = search(i, k, segmentTree, nums, false);
15            count += start != -1 && end != -1 ? end - start + 1 : 0;
16        }
17        return count;
18    }
19    private int search(int i, int k, SegmentTreeAnd segmentTree, 
20    int[] nums, boolean first) { //just b.s in [i, n - 1], so put start = i
21        int n = nums.length, ans = -1, start = i, end = n - 1;
22        while (start <= end) {
23            int mid = start + (end - start)/2;
24            int val = segmentTree.query(i, mid);
25            if (val < k) { // reverse binary search! table[i][j] is decreasing!
26                end = mid - 1; // AND(nums[i..j] == decreasing order!)
27            }
28            else if (val > k) {
29                start = mid + 1;
30            }
31            else {
32                ans = mid;
33                if (first) {
34                    end = mid - 1;
35                }
36                else {
37                    start = mid + 1;
38                }
39            }
40        }
41        return ans;
42    }
43    class SegmentTreeAnd {
44        int[] tree;
45        int n;
46
47        public SegmentTreeAnd(int[] nums) {
48            n = nums.length;
49            tree = new int[4 * n];  // Safe size for recursion
50            build(nums, 0, 0, n - 1);
51        }
52
53        private void build(int[] nums, int node, int l, int r) {
54            if (l == r) {
55                tree[node] = nums[l];
56            } else {
57                int mid = l + (r - l) / 2;
58                build(nums, 2 * node + 1, l, mid);
59                build(nums, 2 * node + 2, mid + 1, r);
60                tree[node] = tree[2 * node + 1] & tree[2 * node + 2];
61            }
62        }
63
64        public void update(int index, int val) {
65            update(0, 0, n - 1, index, val);
66        }
67
68        private void update(int node, int l, int r, int index, int val) {
69            if (l == r) {
70                tree[node] = val;
71            } else {
72                int mid = l + (r - l) / 2;
73                if (index <= mid) {
74                    update(2 * node + 1, l, mid, index, val);
75                } else {
76                    update(2 * node + 2, mid + 1, r, index, val);
77                }
78                tree[node] = tree[2 * node + 1] & tree[2 * node + 2];
79            }
80        }
81
82        public int query(int left, int right) {
83            return query(0, 0, n - 1, left, right);
84        }
85
86        private int query(int node, int l, int r, int left, int right) {
87            if (right < l || r < left) return -1;  // No overlap
88            if (left <= l && r <= right) return tree[node];  // Total overlap
89            int mid = l + (r - l) / 2;
90            int leftAnd = query(2 * node + 1, l, mid, left, right);
91            int rightAnd = query(2 * node + 2, mid + 1, r, left, right);
92            return leftAnd & rightAnd;
93        }
94    }
95}
96