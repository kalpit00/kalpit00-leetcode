// Last updated: 8/18/2025, 12:24:00 AM
class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        SegmentTreeAnd segmentTree = new SegmentTreeAnd(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int min = search(i, target, segmentTree, n);
            res = Math.min(res, min);
            if (res == 0) break;
        }
        return res;
    }

    private int search(int i, int target, SegmentTreeAnd segmentTree, int n) {
        int start = i, end = n - 1, min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = segmentTree.query(i, mid);
            min = Math.min(min, Math.abs(val - target));
            if (val == target) {
                return 0;
            }
            else if (val > target) {
                start = mid + 1;
            }
            else if (val < target) {
                end = mid - 1;
            }
        }
        return min;
    }

    class SegmentTreeAnd {
        int[] tree;
        int n;

        public SegmentTreeAnd(int[] nums) {
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
                tree[node] = tree[2 * node + 1] & tree[2 * node + 2];
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
                tree[node] = tree[2 * node + 1] & tree[2 * node + 2];
            }
        }

        public int query(int left, int right) {
            return query(0, 0, n - 1, left, right);
        }

        private int query(int node, int l, int r, int left, int right) {
            if (right < l || r < left) return -1;  // No overlap
            if (left <= l && r <= right) return tree[node];  // Total overlap
            int mid = l + (r - l) / 2;
            int leftAnd = query(2 * node + 1, l, mid, left, right);
            int rightAnd = query(2 * node + 2, mid + 1, r, left, right);
            return leftAnd & rightAnd;
        }
    }
}
