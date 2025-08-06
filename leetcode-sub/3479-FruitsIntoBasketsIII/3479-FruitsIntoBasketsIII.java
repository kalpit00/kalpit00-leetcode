// Last updated: 8/5/2025, 9:20:07 PM
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, count = 0;
        SegmentTree segmentTree = new SegmentTree(baskets);
        for (int fruit : fruits) { // If no basket can fit this fruit, skip
            if (segmentTree.tree[0] < fruit) continue;
            int idx = segmentTree.findFirst(0, 0, n - 1, fruit);
            segmentTree.update(idx, -1);
            count++;
        }
        return n - count;
    }

    class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new int[4 * n];
            build(nums, 0, 0, n - 1);
        }

        private void build(int[] nums, int node, int l, int r) {
            if (l == r) {
                tree[node] = nums[l];
                return;
            }
            int mid = l + (r - l) / 2;
            build(nums, 2 * node + 1, l, mid);
            build(nums, 2 * node + 2, mid + 1, r);
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        private void update(int node, int l, int r, int index, int val) {
            if (l == r) {
                tree[node] = val;
                return;
            }
            int mid = l + (r - l) / 2;
            if (index <= mid) {
                update(2 * node + 1, l, mid, index, val);
            } else {
                update(2 * node + 2, mid + 1, r, index, val);
            }
            tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public int query(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }

        private int query(int node, int l, int r, int left, int right) {
            if (right < l || r < left) return Integer.MIN_VALUE; // No overlap
            if (left <= l && r <= right) return tree[node]; // Total overlap
            int mid = l + (r - l) / 2;
            int leftMax = query(2 * node + 1, l, mid, left, right);
            int rightMax = query(2 * node + 2, mid + 1, r, left, right);
            return Math.max(leftMax, rightMax);
        }
        public int findFirst(int node, int l, int r, int target) {
            if (l == r) return l;
            int mid = l + (r - l) / 2;
            // If left child has a valid basket, go left; otherwise go right
            if (tree[2 * node + 1] >= target) {
                return findFirst(2 * node + 1, l, mid, target);
            } 
            else {
                return findFirst(2 * node + 2, mid + 1, r, target);
            }
        }
    }
}