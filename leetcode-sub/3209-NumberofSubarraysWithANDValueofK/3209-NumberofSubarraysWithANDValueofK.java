// Last updated: 4/20/2025, 2:06:21 PM
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        SparseTable table = new SparseTable(nums);
        for (int i = 0; i < n; i++) {
            int first = search(i, k, table, nums, true);
            int last = search(i, k, table, nums, false);
            if (table.query(i, first) == k) {
                ans += (last - first + 1);
            }
        }
        return ans;
    }
    private int search(int i, int k, SparseTable table, 
    int[] nums, boolean first) {
        int ans = -1, start = i, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int target = table.query(i, mid);
            if (target < k) {
                end = mid - 1;
            }
            else if (target > k) {
                start = mid + 1;
            }
            else {
                ans = mid;
                if (first) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
    class SparseTable {
        int[][] table;
        int k, n;
        public SparseTable(int[] a) {
            n = a.length;
            k = 22;
            table = new int[k][n];
            for (int i = 0; i < n; i++) {
                table[0][i] = a[i];
            }
            for (int i = 1; i < k; i++) {
                for (int j = 0; j + (1 << i) <= n; j++) {
                    table[i][j] = table[i - 1][j] & 
                    table[i - 1][j + (1 << (i - 1))];
                }
            }
        }
        public int query(int l, int r) {
            if (l > r) return Integer.MAX_VALUE;
            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            return table[x][l] & table[x][r - (1 << x) + 1];
        }
    }
}
