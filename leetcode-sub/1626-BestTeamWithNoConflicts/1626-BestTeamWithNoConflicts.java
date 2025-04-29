// Last updated: 4/29/2025, 1:29:34 AM
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
        FenwickTree fenwickTree = new FenwickTree(size + 2);
        for (int i = 0; i < n; i++) {
            int idx = indices[i];
            int sum = fenwickTree.query(ages[idx]);
            sum += scores[idx];
            max = Math.max(max, sum);
            fenwickTree.update(ages[idx], sum);
        }
        return max;
    }
     class FenwickTree {
        int[] tree;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }
        public int query(int index) {
            int max = 0;
            index++;
            while (index > 0) {
                max = Math.max(max, tree[index]);
                index -= index & (-index);
            }
            return max;
        }

        public void update(int index, int val) {
            index++;
            while (index < tree.length) {
                tree[index] = Math.max(tree[index], val);
                index += index & (-index);
            }
        }
        public int rangeQuery(int left, int right) {
            int max = 0;
            left++;
            while (left <= right) {
                max = Math.max(max, tree[right]);
                right -= right & (-right);
            }
            return max;
        }
    }
}