// Last updated: 4/29/2025, 6:46:37 PM
class Solution {
    public int createSortedArray(int[] instructions) {
        int max = Integer.MIN_VALUE, cost = 0, mod = 1000000007;
        for (int num : instructions) {
            max = Math.max(max, num);
        }
        FenwickTree fenwickTree = new FenwickTree(max + 1);
        for (int value : instructions) {
            int left = fenwickTree.query(value - 1);
            int right = fenwickTree.query(max) - fenwickTree.query(value);
            cost += Math.min(left, right);
            cost %= mod;
            fenwickTree.update(value, 1);
        }
        return cost;
    }
    class FenwickTree {
        int[] tree;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }
        public int query(int index) {
            int sum = 0;
            index++;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }

        public void update(int index, int val) {
            index++;
            while (index < tree.length) {
                tree[index] += val;
                index += index & (-index);
            }
        }
        public int rangeQuery(int left, int right) {
            int sum = 0;
            left++;
            while (left <= right) {
                sum += tree[right];
                right -= right & (-right);
            }
            return sum;
        }
    }
}