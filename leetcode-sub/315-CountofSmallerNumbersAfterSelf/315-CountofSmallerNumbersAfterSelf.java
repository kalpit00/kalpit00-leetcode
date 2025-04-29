// Last updated: 4/29/2025, 3:04:05 PM
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        SegmentTree segmentTree = new SegmentTree(max - min + 1);
        Integer[] res = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx = nums[i] - min;
            res[i] = segmentTree.query(0, idx);
            segmentTree.update(idx, 1);
        }
        return Arrays.asList(res);
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