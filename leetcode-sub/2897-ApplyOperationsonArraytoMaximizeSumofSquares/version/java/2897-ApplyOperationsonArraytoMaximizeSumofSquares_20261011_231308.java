// Last updated: 10/11/2026, 11:13:08 PM
1class Solution {
2
3    public int maxSum(List<Integer> nums, int k) {
4        final int MOD = 1000000007;
5        int[] cnt = new int[30];
6
7        // Count the number of 1 bits at each position
8        for (int num : nums) {
9            for (int i = 0; i < 30; i++) {
10                if ((num & (1 << i)) != 0) {
11                    cnt[i]++;
12                }
13            }
14        }
15
16        long res = 0;
17        for (int i = 0; i < k; i++) {
18            long cur = 0;
19            // Construct the current number from the most significant bit to the least significant bit
20            for (int j = 29; j >= 0; j--) {
21                if (cnt[j] > 0) {
22                    cur |= 1L << j;
23                    cnt[j]--;
24                }
25            }
26            res = (res + cur * cur) % MOD;
27        }
28
29        return (int) res;
30    }
31}