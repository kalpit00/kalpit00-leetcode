// Last updated: 9/21/2026, 12:23:18 AM
1class Solution {
2
3    public long[] resultArray(int[] nums, int k) {
4        int n = nums.length;
5        long[] result = new long[k];
6        long[] dp = new long[k]; // Initial state: no elements have been processed, so no non-empty subarray exists.
7
8        for (int i = 0; i < n; i++) {
9            long[] ndp = new long[k]; // Current-layer state (rolling array).
10            ndp[nums[i] % k]++;
11            for (int r = 0; r < k; r++) {
12                ndp[(int) (((long) r * nums[i]) % k)] += dp[r];
13            }
14            dp = ndp; // Update the state.
15            // Accumulate the answer.
16            for (int r = 0; r < k; r++) {
17                result[r] += dp[r];
18            }
19        }
20
21        return result;
22    }
23}