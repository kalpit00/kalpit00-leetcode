// Last updated: 4/29/2025, 6:47:46 PM
class Solution {
    public int createSortedArray(int[] instructions) {
        int max = Integer.MIN_VALUE, cost = 0, mod = 1000000007;
        for (int num : instructions) {
            max = Math.max(max, num);
        }
        SegmentTree segmentTree = new SegmentTree(max + 1);
        for (int value : instructions) {
            int left = segmentTree.query(0, value);
            int right = segmentTree.query(0, max + 1) - segmentTree.query(0, value + 1);
            cost += Math.min(left, right);
            cost %= mod;
            segmentTree.update(value, 1);
        }
        return cost;
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
            int sum = 0;
            while (left < right) {
                if ((left & 1) == 1) { // left % 2 == 1
                    sum += tree[left++];
                }
                if ((right & 1) == 1) { // right % 2 == 1
                    sum += tree[--right];
                }
                left >>= 1; // left /= 2
                right >>= 1; // right /= 2
            }
            return sum;
        }

        public void update(int index, int val) {
            index += n;
            tree[index] += val;
            while (index > 1) {
                index >>= 1; // index /= 2
                tree[index] = tree[2 * index] + tree[2 * index + 1];
            }
        }
    }
}