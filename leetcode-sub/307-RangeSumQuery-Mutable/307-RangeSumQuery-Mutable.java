// Last updated: 5/3/2025, 4:40:54 PM
class NumArray {
    SegmentTree segmentTree;
    public NumArray(int[] nums) {
        segmentTree = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        segmentTree.update(index, val);
    }
    
    public int sumRange(int left, int right) {
        return segmentTree.query(left, right);
    }
    class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int[] nums) {
            n = nums.length;
            tree = new int[4 * n];  // Safe size for recursion
            build(nums, 0, 0, n - 1);
        }

        private void build(int[] nums, int node, int l, int r) {
            if (l == r) {
                tree[node] = nums[l];
            } else {
                int mid = l + (r - l) / 2;
                build(nums, 2 * node + 1, l, mid);
                build(nums, 2 * node + 2, mid + 1, r);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public void update(int index, int val) {
            update(0, 0, n - 1, index, val);
        }

        private void update(int node, int l, int r, int index, int val) {
            if (l == r) {
                tree[node] = val;
            } else {
                int mid = l + (r - l) / 2;
                if (index <= mid) {
                    update(2 * node + 1, l, mid, index, val);
                } else {
                    update(2 * node + 2, mid + 1, r, index, val);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public int query(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }

        private int query(int node, int l, int r, int left, int right) {
            if (right < l || r < left) return 0;  // No overlap
            if (left <= l && r <= right) return tree[node];  // Total overlap
            int mid = l + (r - l) / 2;
            int leftSum = query(2 * node + 1, l, mid, left, right);
            int rightSum = query(2 * node + 2, mid + 1, r, left, right);
            return leftSum + rightSum;
        }
    }
}