// Last updated: 8/17/2025, 11:34:43 PM
class Solution {
    public int minStable(int[] nums, int maxC) {
        int n = nums.length, start = 0, end = n, ans = n;
        SparseTable table = new SparseTable(nums);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(nums, mid, maxC, table)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    private boolean helper(int[] nums, int mid, int maxC, SparseTable table) {
        int n = nums.length, count = 0, i = 0;
        while (i + mid < n) {
            int gcd = table.query(i, i + mid);
            if (gcd > 1) {
                count++;
                i += mid + 1;
            } else {
                i++;
            }
        }
        return count <= maxC;
    }
    
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
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
                    table[i][j] = gcd(table[i][j - 1], table[i + (1 << (j - 1))][j - 1]);
                }
            }
        }
        public int query(int l, int r) {
            if (l > r) return Integer.MAX_VALUE;
            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            return gcd(table[l][x], table[r - (1 << x) + 1][x]);
        }
    }
}