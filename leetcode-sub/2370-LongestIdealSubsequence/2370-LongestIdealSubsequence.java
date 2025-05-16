// Last updated: 5/15/2025, 10:57:30 PM
class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length(), max = 0;
        SegmentTree segmentTree = new SegmentTree(26);
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            int left = Math.max(0, idx - k);
            int right = Math.min(26, idx + k + 1);
            int res = segmentTree.query(left, right) + 1;
            max = Math.max(max, res);
            segmentTree.update(idx, res);
        }
        return max;
    }
    class SegmentTree {
        int[] tree;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            this.tree = new int[2 * n];
        }

        public int query(int left, int right) {
            left += n;
            right += n;
            int max = 0; // replace count with max!
            while (left < right) {
                if ((left & 1) == 1) { // left % 2 == 1
                    max = Math.max(max, tree[left++]);
                } // max the left and right instead of adding!
                if ((right & 1) == 1) { // right % 2 == 1
                    max = Math.max(max, tree[--right]);
                }
                left >>= 1; // left /= 2
                right >>= 1; // right /= 2
            }
            return max;
        }

        public void update(int index, int val) {
            index += n;
            tree[index] = val; // replace += with = as only maxxing all nodes
            while (index > 1) {
                index >>= 1; // index /= 2
                tree[index] = Math.max(tree[2 * index], tree[2 * index + 1]);
            } // max the two children instead of adding!
        }
    }
}