// Last updated: 3/1/2026, 3:34:51 PM
1class Solution {
2    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
3        int n = nums.length, m = queries.length;
4        boolean[] res = new boolean[m];
5        int[] arr = new int[n];
6        for (int i = 1; i < n; i++) {
7            arr[i] = arr[i - 1];
8            arr[i] += nums[i] % 2 == nums[i - 1] % 2 ? 1 : 0;
9        } // add 1 if same parity 
10        for (int i = 0; i < m; i++) {
11            res[i] = arr[queries[i][1]] == arr[queries[i][0]];
12        } // if [arr[i] == arr[j] -> [i, j] have opp parity pairs]
13        return res;
14    }
15}