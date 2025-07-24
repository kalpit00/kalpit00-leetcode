// Last updated: 7/24/2025, 3:03:43 PM
class Solution {
    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        FenwickTree bit = new FenwickTree(n + 1);
        for (int i = 0; i < n; i++) {
            int curr = nums[i] - bit.query(i);
            if (curr < 0) return false;
            if (curr > 0) {
                if (i + k > n) return false;
                bit.update(i, curr);
                bit.update(i + k, -curr);
            }
        }
        return true;
    }

    class FenwickTree {
        int[] tree;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void update(int i, int delta) {
            for (i++; i <= n; i += i & -i) tree[i] += delta;
        }

        int query(int i) {
            int sum = 0;
            for (i++; i > 0; i -= i & -i) sum += tree[i];
            return sum;
        }
    }
}
