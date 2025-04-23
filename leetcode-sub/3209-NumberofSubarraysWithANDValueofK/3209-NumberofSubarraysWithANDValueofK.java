// Last updated: 4/23/2025, 12:44:34 PM
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long count = 0;
        SparseTable table = new SparseTable(nums);
        for (int i = 0; i < n; i++) {
            int start = search(i, k, table, nums, true);
            int end = search(i, k, table, nums, false);
            count += start != -1 && end != -1 ? end - start + 1 : 0;
        }
        return count;
    }
    private int search(int i, int k, SparseTable table, 
    int[] nums, boolean first) { //just b.s in [i, n - 1], so put start = i
        int n = nums.length, ans = -1, start = i, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            int val = table.query(i, mid);
            if (val < k) { // reverse binary search! table[i][j] is decreasing!
                end = mid - 1; // AND(nums[i..j] == decreasing order!)
            }
            else if (val > k) {
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
        public SparseTable(int[] nums) {
            n = nums.length;
            k = 22;
            table = new int[n][k];
            for (int i = 0; i < n; i++) {
                table[i][0] = nums[i];
            }
            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    table[i][j] = table[i][j - 1] & table[i + (1 << (j - 1))][j - 1];
                }
            }
        }
        public int query(int l, int r) {
            if (l > r) return Integer.MAX_VALUE;
            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
            return table[l][x] & table[r - (1 << x) + 1][x];
        }
    }
}
