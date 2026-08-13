// Last updated: 8/13/2026, 11:32:50 AM
1class Solution {
2    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
3        char[] arr = s.toCharArray(), q = queryCharacters.toCharArray();
4        int n = arr.length, k = queryIndices.length;
5        int[] nums = new int[n], res = new int[k];
6        for (int i = 0; i < n; i++) {
7            nums[i] = arr[i] - 'a';
8        }
9        SegmentTree segmentTree = new SegmentTree(nums);
10        for (int i = 0; i < k; i++) {
11            segmentTree.update(0, n - 1, 0, queryIndices[i], q[i] - 'a');
12            res[i] = segmentTree.tree[0][0];
13        }
14        return res;
15    }
16
17    class SegmentTree {
18        int[][] tree;
19        int n;
20        public SegmentTree(int[] nums) {
21            this.n = nums.length;
22            tree = new int[4 * n][5]; // <maxLen, prefix, suffix, left, right>
23            build(nums, 0, n - 1, 0);
24        }
25
26        public void build(int[] nums, int l, int r, int node) {
27            if (l == r) {
28                tree[node] = new int[]{1, 1, 1, nums[l], nums[l]};
29                return;
30            }
31            int mid = l + (r - l) / 2;
32            build(nums, l, mid, 2 * node + 1);
33            build(nums, mid + 1, r, 2 * node + 2);
34            tree[node] = merge(2 * node + 1, 2 * node + 2, 
35            mid - l + 1, r - mid);
36        } // tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
37
38        public void update(int l, int r, int node, int index, int val) {
39            if (l == r) {
40                tree[node] = new int[]{1, 1, 1, val, val};
41                return;
42            }
43            int mid = l + (r - l) / 2;
44            if (index <= mid) {
45                update(l, mid, 2 * node + 1, index, val);
46            } 
47            else {
48                update(mid + 1, r, 2 * node + 2, index, val);
49            } // merge is the variation here, from std sum/min/max segment trees
50            tree[node] = merge(2 * node + 1, 2 * node + 2, 
51            mid - l + 1, r - mid);
52        } // tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
53
54        public int[] merge(int left, int right, int leftSize, int rightSize) {
55            int pre = tree[left][1];
56            if (tree[left][1] == leftSize && tree[left][4] == tree[right][3]) {
57                pre += tree[right][1];
58            }
59            int suf = tree[right][2];
60            if (tree[right][2] == rightSize && tree[left][4] == tree[right][3]){
61                suf += tree[left][2];
62            }
63            int max = Math.max(tree[left][0], tree[right][0]);
64            if (tree[left][4] == tree[right][3]) {
65                max = Math.max(max, tree[left][2] + tree[right][1]);
66            }
67            return new int[]{max, pre, suf, tree[left][3], tree[right][4]};
68        }
69    }
70}