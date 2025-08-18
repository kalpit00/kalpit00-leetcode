// Last updated: 8/17/2025, 8:57:06 PM
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length, size = 0, max = 0;
        for (int num : nums) size = Math.max(size, num);
        SegmentTreeMax segmentTree = new SegmentTreeMax(size + 1);        
        for (int num : nums) {
            int left = Math.max(0, num - k), right = num - 1;
            int res = (left <= right) ? segmentTree.query(left, right) : 0;
            segmentTree.update(num, res + 1);
            max = Math.max(max, res + 1);
        }
        return max;
    }
    
    class SegmentTreeMax {
        int[] tree;
        int n;
        
        public SegmentTreeMax(int size) {
            n = size;
            tree = new int[4 * n];
        }
        
        public void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }
        
        private void update(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] = Math.max(tree[node], val);
                return;
            }
            
            int mid = l + (r - l) / 2;
            if (idx <= mid) {
                update(2 * node, l, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, r, idx, val);
            }            
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
        
        // Range query: get maximum in range [ql, qr]
        public int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }
        
        private int query(int node, int l, int r, int ql, int qr) {
            // No overlap
            if (qr < l || r < ql) {
                return 0; // Return neutral value for max operation
            }
            
            // Complete overlap
            if (ql <= l && r <= qr) {
                return tree[node];
            }
            // Partial overlap
            int mid = l + (r - l) / 2;
            int leftMax = query(2 * node, l, mid, ql, qr);
            int rightMax = query(2 * node + 1, mid + 1, r, ql, qr);
            return Math.max(leftMax, rightMax);
        }
    }
}