// Last updated: 2/17/2026, 10:25:36 PM
1class Solution {
2    public boolean hasAlternatingBits(int n) {
3        return (n & (n >> 1)) == 0 && (n & (n >> 2)) == (n >> 2);
4    }
5}