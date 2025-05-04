// Last updated: 5/4/2025, 12:45:28 AM
class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length, size = 0, maxLen = 0;
        for (int num : nums) size = Math.max(size, num);
        
        SegmentTreeLazyMax segmentTree = new SegmentTreeLazyMax(size + 2);
        int[] arr = new int[size + 2];  // Track original values
        
        for (int num : nums) {
            int left = Math.max(0, num - k);
            int right = num - 1;  // we want strictly less than num
            
            int maxInRange = (left <= right) ? segmentTree.query(left, right) : 0;
            int newVal = maxInRange + 1;
            
            int diff = newVal - arr[num];
            arr[num] = newVal;
            segmentTree.update(num, num, diff);  // point update as range
            
            maxLen = Math.max(maxLen, newVal);
        }
        return maxLen;
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
                tree[node] += lazy[node];
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

        private void update(int node, int nodeL, int nodeR, int l, int r, int val) {
            push(node, nodeL, nodeR);
            if (nodeR < l || nodeL > r) return;
            if (l <= nodeL && nodeR <= r) {
                lazy[node] += val;
                push(node, nodeL, nodeR);
                return;
            }
            int mid = (nodeL + nodeR) / 2;
            update(2 * node, nodeL, mid, l, r, val);
            update(2 * node + 1, mid + 1, nodeR, l, r, val);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        public int query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }

        private int query(int node, int nodeL, int nodeR, int l, int r) {
            push(node, nodeL, nodeR);
            if (nodeR < l || nodeL > r) return 0;
            if (l <= nodeL && nodeR <= r) return tree[node];
            int mid = (nodeL + nodeR) / 2;
            int leftMax = query(2 * node, nodeL, mid, l, r);
            int rightMax = query(2 * node + 1, mid + 1, nodeR, l, r);
            return Math.max(leftMax, rightMax);
        }
    }
}
