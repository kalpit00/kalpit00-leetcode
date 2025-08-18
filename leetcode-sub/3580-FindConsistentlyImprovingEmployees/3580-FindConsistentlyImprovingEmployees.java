// Last updated: 8/17/2025, 11:40:20 PM
class Solution {
    public int minStable(int[] nums, int maxC) {
        int n = nums.length, start = 0, end = n, ans = n;
        SegmentTreeGcd segmentTree = new SegmentTreeGcd(nums);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(nums, mid, maxC, segmentTree)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    private boolean helper(int[] nums, int mid, int maxC, 
    SegmentTreeGcd segmentTree) {
        int n = nums.length, count = 0, i = 0;
        while (i + mid < n) {
            int gcd = segmentTree.query(i, i + mid);
            if (gcd > 1) {
                count++;
                i += mid + 1;
            } else {
                i++;
            }
        }
        return count <= maxC;
    }
    
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    class SegmentTreeGcd {
        int[] tree;
        int n;

        public SegmentTreeGcd(int[] nums) {
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
                tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
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
                tree[node] = gcd(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        public int query(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }

        private int query(int node, int l, int r, int left, int right) {
            if (right < l || r < left) return 0;  // No overlap
            if (left <= l && r <= right) return tree[node];  // Total overlap
            int mid = l + (r - l) / 2;
            int leftGcd = query(2 * node + 1, l, mid, left, right);
            int rightGcd = query(2 * node + 2, mid + 1, r, left, right);
            return gcd(leftGcd, rightGcd);
        }
    }
}