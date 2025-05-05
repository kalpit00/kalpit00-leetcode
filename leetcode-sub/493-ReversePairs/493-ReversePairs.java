// Last updated: 5/5/2025, 1:41:59 AM
class Solution {
    public int reversePairs(int[] nums) {
        Set<Long> set = new TreeSet<>();
        for (int num : nums) {
            set.add(1L * num);
            set.add(2L * num);
        }
        Map<Long, Integer> map = new HashMap<>();
        int rank = 0, count = 0;
        for (long val : set) {
            map.put(val, rank++);
        }
        SegmentTree seg = new SegmentTree(rank);
        for (int num : nums) {
            int targetIdx = map.get(2L * num);
            count += seg.rangeSum(targetIdx + 1, rank - 1);
            int idx = map.get((long) num);
            seg.pointUpdate(idx, 1);
        }
        return count;
    }

    class SegmentTree {
        int[] tree;
        int size;

        public SegmentTree(int n) {
            size = n;
            tree = new int[4 * n];
        }

        public void pointUpdate(int idx, int val) {
            pointUpdate(1, 0, size - 1, idx, val);
        }

        private void pointUpdate(int node, int l, int r, int idx, int val) {
            if (l == r) {
                tree[node] += val;
                return;
            }
            int mid = (l + r) / 2;
            if (idx <= mid) {
                pointUpdate(node * 2, l, mid, idx, val);
            } else {
                pointUpdate(node * 2 + 1, mid + 1, r, idx, val);
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        public int rangeSum(int ql, int qr) {
            return rangeSum(1, 0, size - 1, ql, qr);
        }

        private int rangeSum(int node, int l, int r, int ql, int qr) {
            if (qr < l || ql > r) return 0;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l + r) / 2;
            return rangeSum(node * 2, l, mid, ql, qr) +
                   rangeSum(node * 2 + 1, mid + 1, r, ql, qr);
        }
    }
}
