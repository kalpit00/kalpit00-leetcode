// Last updated: 4/29/2025, 2:54:06 PM
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        FenwickTree fenwickTree = new FenwickTree(max - min + 1);
        Integer[] res = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx = nums[i] - min;
            res[i] = fenwickTree.query(idx - 1);
            fenwickTree.update(idx, 1);
        }
        return Arrays.asList(res);
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