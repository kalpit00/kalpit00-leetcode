// Last updated: 3/10/2026, 9:00:28 PM
1class Solution {
2    public int bitwiseComplement(int n) {
3        if (n == 0) return 1;
4        int bits = 32 - Integer.numberOfLeadingZeros(n);
5        int mask = (1 << bits) - 1;
6        return ~n & mask;
7    }
8}