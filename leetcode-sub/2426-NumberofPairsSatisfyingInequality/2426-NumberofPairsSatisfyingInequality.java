// Last updated: 4/29/2025, 6:42:57 PM
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int shift = 20000, n = nums1.length;
        SegmentTree segmentTree = new SegmentTree(100001);
        long res = 0;
        for (int i = 0; i < n; i++) {
            int k = nums1[i] - nums2[i];
            res += segmentTree.query(0, k + diff + shift + 1);
            segmentTree.update(k + shift, 1);
        }
        return res;
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
