// Last updated: 2/17/2026, 10:44:36 PM
1class Solution {
2    public int hammingWeight(int n) {
3        int k = 32 - Integer.numberOfLeadingZeros(n), count = 0;
4        for (int i = 0; i < k; i++) {
5            int mask = 1 << i;
6            int b1 = (n & mask) != 0 ? 1 : 0;
7            count += b1 == 1 ? 1 : 0;
8        }
9        return count;
10    }
11}