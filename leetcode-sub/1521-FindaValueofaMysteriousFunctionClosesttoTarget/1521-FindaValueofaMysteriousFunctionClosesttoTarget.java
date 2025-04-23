// Last updated: 4/23/2025, 4:11:56 PM
class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        SparseTable table = new SparseTable(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int min = search(i, target, table, n);
            res = Math.min(res, min);
            if (res == 0) break;
        }
        return res;
    }

    private int search(int i, int target, SparseTable table, int n) {
        int start = i, end = n - 1, min = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int val = table.query(i, mid);
            min = Math.min(min, Math.abs(val - target));
            if (val == target) {
                return 0;
            }
            else if (val > target) {
                start = mid + 1;
            }
            else if (val < target) {
                end = mid - 1;
            }
        }
        return min;
    }

    class SparseTable {
        int[][] table;
        int n, k;
        public SparseTable(int[] arr) {
            n = arr.length;
            k = 32;
            table = new int[n][k];
            for (int i = 0; i < n; i++) {
                table[i][0] = arr[i];
            }
            for (int j = 1; (1 << j) <= n; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    table[i][j] = table[i][j - 1] & table[i + (1 << (j - 1))][j - 1];
                }
            }
        }

        public int query(int l, int r) {
            int range = r - l + 1;
            int x = 31 - Integer.numberOfLeadingZeros(range);
            return table[l][x] & table[r - (1 << x) + 1][x];
        }
    }
}
