// Last updated: 4/29/2025, 1:26:14 AM
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length, max = 0, size = 0;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> (scores[a] == scores[b]) ? ages[a] - ages[b] : scores[a] - scores[b]);
        for (int age : ages) {
            size = Math.max(age, size);
        }
        SegmentTree segmentTree = new SegmentTree(size + 2);
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            int sum = segmentTree.query(0, ages[idx] + 1);
            sum += scores[idx];
            max = Math.max(max, sum);
            segmentTree.update(ages[idx], sum);
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
            int max = 0;
            while (left < right) {
                if ((left & 1) == 1) { // left % 2 == 1
                    max = Math.max(max, tree[left++]);
                }
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
            tree[index] = Math.max(tree[index], val);
            while (index > 1) {
                index >>= 1; // index /= 2
                tree[index] = Math.max(tree[2 * index], tree[2 * index + 1]);
            }
        }
    }
}