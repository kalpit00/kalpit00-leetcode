// Last updated: 4/29/2025, 6:42:05 PM
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int shift = 20000, n = nums1.length;
        FenwickTree fenwickTree = new FenwickTree(100001);
        long res = 0;
        for (int i = 0; i < n; i++) {
            int k = nums1[i] - nums2[i];
            res += fenwickTree.query(k + diff + shift);
            fenwickTree.update(k + shift, 1);
        }
        return res;
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
