// Last updated: 8/18/2025, 12:31:45 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        SparseTable table = new SparseTable(nums);
        for (int i = 0; i <= n - k; i++) {
            res[i] = table.query(i, i + k - 1);
        }
        return res;
    }
    class SparseTable {
        int[][] table;
        int k, n;
        public SparseTable(int[] nums) {
            n = nums.length;
            k = (int) (Math.log(n) / Math.log(2)) + 1;
            table = new int[n][k];
            for (int i = 0; i < n; i++) {
                table[i][0] = nums[i];
            }
            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    table[i][j] = Math.max(table[i][j - 1], table[i + (1 << (j - 1))][j - 1]);
                }
            }
        }
        public int query(int l, int r) {
            if (l > r) return Integer.MAX_VALUE;
            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            return Math.max(table[l][x], table[r - (1 << x) + 1][x]);
        }
    }
}