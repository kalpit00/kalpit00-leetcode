// Last updated: 5/4/2025, 2:23:15 PM
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, max = nums[0];
        boolean allNegative = true;
        for (int i = 0; i < n; i++) {
            allNegative = nums[i] > 0 ? false : allNegative;
            max = Math.max(max, nums[i]);
        }
        if (allNegative) {
            return max;
        }
        SegmentTree segmentTree = new SegmentTree(nums);
        return (int) segmentTree.tree[0][0];
    }

    class SegmentTree {
        long[][] tree;
        int n;
        public SegmentTree(int[] nums) {
            this.n = nums.length;
            tree = new long[4 * n][4]; // <maxSubArrSum, prefix, suffix, total>
            build(nums, 0, n - 1, 0);
        }

        public void build(int[] nums, int l, int r, int node) {
            if (l == r) {
                long max = Math.max(0, nums[l]);
                tree[node] = new long[]{max, max, max, nums[l]};
                return;
            }
            int mid = l + (r - l) / 2;
            build(nums, l, mid, 2 * node + 1);
            build(nums, mid + 1, r, 2 * node + 2);
            tree[node] = merge(node, 2 * node + 1, 2 * node + 2);
        } // tree[node] = tree[2 * node + 1] + tree[2 * node + 2];

        public void update(int l, int r, int node, int index, int val) {
            if (l == r) {
                long max = Math.max(0, val);
                tree[node] = new long[]{max, max, max, val};
                return;
            }
            int mid = l + (r - l) / 2;
            if (index <= mid) {
                update(l, mid, 2 * node + 1, index, val);
            } 
            else {
                update(mid + 1, r, 2 * node + 2, index, val);
            } // merge is the variation here, from std sum/min/max segment trees
            tree[node] = merge(node, 2 * node + 1, 2 * node + 2);
        } // tree[node] = tree[2 * node + 1] + tree[2 * node + 2];

        public long[] merge(int node, int left, int right) {
            long sum = tree[left][3] + tree[right][3];
            long max = Math.max(Math.max(tree[left][0], tree[right][0]),
            tree[left][2] + tree[right][1]);
            long pre = Math.max(tree[left][1], tree[left][3] + tree[right][1]);
            long suf = Math.max(tree[right][2], tree[right][3] + tree[left][2]);
            return new long[]{max, pre, suf, sum};
        } // more about merge() in notes!
    }
}