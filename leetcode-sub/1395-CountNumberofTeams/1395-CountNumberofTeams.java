// Last updated: 4/29/2025, 6:49:44 PM
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length, max = Integer.MIN_VALUE, count = 0;
        for (int num : rating) {
            max = Math.max(max, num);
        }
        FenwickTree leftTree = new FenwickTree(max + 1);
        FenwickTree rightTree = new FenwickTree(max + 1);
        for (int num : rating) {
            rightTree.update(num, 1);
        }
        for (int i = 0; i < n; i++) {
            rightTree.update(rating[i], -1);
            int lessLeft = leftTree.query(rating[i] - 1);
            int greaterLeft = i - lessLeft;
            int lessRight = rightTree.query(rating[i] - 1);
            int greaterRight = (n - i - 1) - lessRight;
            count += lessLeft * greaterRight; // [i < j < k]
            count += greaterLeft * lessRight; // [i > j > k]
            leftTree.update(rating[i], 1);
        }
        return count;
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
