// Last updated: 7/24/2025, 3:04:37 PM
class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        SegmentTreeLazy segmentTree = new SegmentTreeLazy(n);
        for (int i = 0; i < n; i++) {
            int curr = nums[i] - segmentTree.query(i, i);
            if (curr < 0) return false;
            if (curr > 0) {
                if (i + k > n) return false;
                segmentTree.update(i, i + k - 1, curr);
            }
        }
        return true;
    }

    class SegmentTreeLazy {
        int[] tree, lazy;
        int n;

        public SegmentTreeLazy(int size) {
            n = size;
            tree = new int[4 * n];
            lazy = new int[4 * n];
        }

        void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                tree[node] += (r - l + 1) * lazy[node];
                if (l != r) {
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }
                lazy[node] = 0;
            }
        }

        public void update(int l, int r, int val) {
            update(1, 0, n - 1, l, r, val);
        }

        private void update(int node, int l, int r, int ql, int qr, int val) {
            push(node, l, r);
            if (qr < l || r < ql) return;
            if (ql <= l && r <= qr) {
                lazy[node] += val;
                push(node, l, r);
                return;
            }
            int mid = l + (r - l) / 2;
            update(2 * node, l, mid, ql, qr, val);
            update(2 * node + 1, mid + 1, r, ql, qr, val);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        public int query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            push(node, l, r);
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = l + (r - l) / 2;
            return query(2 * node, l, mid, ql, qr) +
                   query(2 * node + 1, mid + 1, r, ql, qr);
        }
    }
}
