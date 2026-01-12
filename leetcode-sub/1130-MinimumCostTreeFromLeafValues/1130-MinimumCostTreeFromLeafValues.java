// Last updated: 1/12/2026, 1:49:47 PM
1class Solution {
2    public int mctFromLeafValues(int[] arr) {
3        int n = arr.length;
4        SparseTable table = new SparseTable(arr);
5        Integer[][] dp = new Integer[n + 1][n + 1];
6        return solve(0, n - 1, arr, dp, table);
7    }
8    private int solve(int i, int j, int[] arr, Integer[][] dp, 
9    SparseTable table) {
10        if (i >= j) {
11            return 0;
12        }
13        if (dp[i][j] != null) {
14            return dp[i][j];
15        }
16        int min = Integer.MAX_VALUE;
17        for (int k = i; k < j; k++) {
18            int left = table.queryMax(i, k), right = table.queryMax(k + 1, j);
19            min = Math.min(min, left * right + solve(i, k, arr, dp, table) + 
20            solve(k + 1, j, arr, dp, table));
21        }
22        return dp[i][j] = min;
23    }
24    class SparseTable {
25        int[][][] table;
26        int k, n;
27        public SparseTable(int[] nums) {
28            n = nums.length;
29            k = (int) (Math.log(n) / Math.log(2)) + 1;
30            table = new int[n][k][2];
31            for (int i = 0; i < n; i++) {
32                table[i][0][0] = nums[i];
33                table[i][0][1] = nums[i];
34            }
35            for (int j = 1; j < k; j++) {
36                for (int i = 0; i + (1 << j) <= n; i++) {
37                    table[i][j][0] = Math.max(table[i][j - 1][0], table[i + (1 << (j - 1))][j - 1][0]);
38                    table[i][j][1] = Math.min(table[i][j - 1][1], table[i + (1 << (j - 1))][j - 1][1]);
39                }
40            }
41        }
42        public int queryMax(int l, int r) {
43            if (l > r) return Integer.MAX_VALUE;
44            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
45            return Math.max(table[l][x][0], table[r - (1 << x) + 1][x][0]);
46        }
47        public int queryMin(int l, int r) {
48            if (l > r) return Integer.MIN_VALUE;
49            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
50            return Math.min(table[l][x][1], table[r - (1 << x) + 1][x][1]);
51        }
52    }
53}