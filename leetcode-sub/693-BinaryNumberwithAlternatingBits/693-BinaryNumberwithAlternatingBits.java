// Last updated: 2/17/2026, 10:37:09 PM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        int k = 32 - Integer.numberOfLeadingZeros(n);
4        for (int i = 1; i < k; i++) {
5            int mask1 = 1 << i, mask2 = 1 << (i - 1);
6            int b1 = (n & mask1) != 0 ? 1 : 0;
7            int b2 = (n & mask2) != 0 ? 1 : 0;
8            if (b1 == b2) return false;
9        }
10        return true;
11    }
12}
13