// Last updated: 4/29/2025, 6:50:41 PM
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length, max = Integer.MIN_VALUE, count = 0;
        for (int num : rating) {
            max = Math.max(max, num);
        }
        SegmentTree leftTree = new SegmentTree(max + 1);
        SegmentTree rightTree = new SegmentTree(max + 1);
        for (int num : rating) {
            rightTree.update(num, 1);
        }
        for (int i = 0; i < n; i++) {
            rightTree.update(rating[i], -1);
            int lessLeft = leftTree.query(0, rating[i]);
            int greaterLeft = i - lessLeft;
            int lessRight = rightTree.query(0, rating[i]);
            int greaterRight = (n - i - 1) - lessRight;
            count += lessLeft * greaterRight; // [i < j < k]
            count += greaterLeft * lessRight; // [i > j > k]
            leftTree.update(rating[i], 1);
        }
        return count;
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
