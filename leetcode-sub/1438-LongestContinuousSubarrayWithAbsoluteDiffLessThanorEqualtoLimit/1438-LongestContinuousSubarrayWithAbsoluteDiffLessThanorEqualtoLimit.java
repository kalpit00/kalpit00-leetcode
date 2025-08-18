// Last updated: 8/18/2025, 5:50:07 PM
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        SparseTable table = new SparseTable(nums);
        int n = nums.length, left = 0, right = 0, max = 0;
        while (right < n) {
            while (left < n && table.queryMax(left, right) - 
            table.queryMin(left, right) > limit) {
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
    class SparseTable {
        int[][][] table;
        int k, n;
        public SparseTable(int[] nums) {
            n = nums.length;
            k = (int) (Math.log(n) / Math.log(2)) + 1;
            table = new int[n][k][2];
            for (int i = 0; i < n; i++) {
                table[i][0][0] = nums[i];
                table[i][0][1] = nums[i];
            }
            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    table[i][j][0] = Math.max(table[i][j - 1][0], table[i + (1 << (j - 1))][j - 1][0]);
                    table[i][j][1] = Math.min(table[i][j - 1][1], table[i + (1 << (j - 1))][j - 1][1]);
                }
            }
        }
        public int queryMax(int l, int r) {
            if (l > r) return Integer.MAX_VALUE;
            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            return Math.max(table[l][x][0], table[r - (1 << x) + 1][x][0]);
        }
        public int queryMin(int l, int r) {
            if (l > r) return Integer.MIN_VALUE;
            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            return Math.min(table[l][x][1], table[r - (1 << x) + 1][x][1]);
        }
    }
}