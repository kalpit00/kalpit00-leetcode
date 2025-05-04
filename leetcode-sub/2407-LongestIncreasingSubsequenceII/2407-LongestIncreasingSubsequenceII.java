// Last updated: 5/4/2025, 12:57:12 AM
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length, size = 0, max = 0;
        for (int num : nums) size = Math.max(size, num);
        SegmentTreeLazyMax segmentTree = new SegmentTreeLazyMax(size + 2);
        int[] arr = new int[size + 2]; 
        for (int num : nums) {
            int left = Math.max(0, num - k), right = num - 1;
            int res = (left <= right) ? segmentTree.query(left, right) + 1 : 1;
            int diff = res - arr[num];
            arr[num] = res;
            segmentTree.update(num, num, diff);
            max = Math.max(max, res);
        }
        return max;
    }

    class SegmentTreeLazyMax {
        int[] tree, lazy;
        int n;

        public SegmentTreeLazyMax(int size) {
            n = size;
            tree = new int[4 * n];
            lazy = new int[4 * n];
        }

        private void push(int node, int l, int r) {
            if (lazy[node] != 0) {
                tree[node] += (r - l + 1) * lazy[node];
                if (l != r) { // Not a leaf
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
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        public int query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            push(node, l, r);
            if (qr < l || r < ql) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = l + (r - l) / 2;
            int leftMax = query(2 * node, l, mid, ql, qr);
            int rightMax = query(2 * node + 1, mid + 1, r, ql, qr);
            return Math.max(leftMax, rightMax);
        }
    }
}
