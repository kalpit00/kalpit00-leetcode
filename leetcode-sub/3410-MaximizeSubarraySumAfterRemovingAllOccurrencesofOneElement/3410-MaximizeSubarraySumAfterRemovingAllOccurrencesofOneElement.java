// Last updated: 5/4/2025, 12:27:46 PM
class Solution {
    public long maxSubarraySum(int[] nums) {
        int n = nums.length, max = nums[0];
        boolean allNegative = true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            allNegative = nums[i] > 0 ? false : allNegative;
            max = Math.max(max, nums[i]);
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        } // map all occurences of an ele together, get their indices in a list
        if (allNegative) {
            return max; // if ALL negative elements
        } // maxSubArraySum is just the least negative ele. return max
        SegmentTree segmentTree = new SegmentTree(nums);
        long res = segmentTree.tree[0][0]; // [0] is root, [0][0] is the maxSubArraySum stored at each node of the segment tree!
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int val = entry.getKey();
            List<Integer> indices = entry.getValue();
            for (int idx : indices) {
                segmentTree.update(0, n - 1, 0, idx, 0);
            } // update all "indices" to 0 for this particular element!
            res = Math.max(res, segmentTree.tree[0][0]); // max the res at root!
            for (int idx : indices) {
                segmentTree.update(0, n - 1, 0, idx, val);
            } // update all indices back to original val!
        } // using segment tree, we update entire ranges in logarithmic time!
        return res;
    }

    class SegmentTree {
        long[][] tree;
        int n;
        int[] arr;
        public SegmentTree(int[] nums) {
            this.n = nums.length;
            this.arr = nums;
            tree = new long[4 * n][4]; // <maxSubArrSum, prefix, suffix, total>
            build(0, n - 1, 0);
        }

        public void build(int l, int r, int node) {
            if (l == r) {
                long max = Math.max(0, arr[l]);
                tree[node] = new long[]{max, max, max, arr[l]};
                return;
            }
            int mid = l + (r - l) / 2;
            build(l, mid, 2 * node + 1);
            build(mid + 1, r, 2 * node + 2);
            merge(node, 2 * node + 1, 2 * node + 2);
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
            merge(node, 2 * node + 1, 2 * node + 2);
        } // tree[node] = tree[2 * node + 1] + tree[2 * node + 2];

        public void merge(int node, int left, int right) {
            long[] res = new long[4];
            long sum = tree[left][3] + tree[right][3];
            long max = Math.max(Math.max(tree[left][0], tree[right][0]), tree[left][2] + tree[right][1]);
            long pre = Math.max(tree[left][1], tree[left][3] + tree[right][1]);
            long suf = Math.max(tree[right][2], tree[right][3] + tree[left][2]);
            tree[node] = new long[]{max, pre, suf, sum};
        } // more about merge() in notes!
    }
}
