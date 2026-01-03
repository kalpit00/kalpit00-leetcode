// Last updated: 1/3/2026, 3:07:30 AM
1class Solution {
2    public int numOfWays(int n) {
3        int MOD = 1000000007;
4        long typeA = 6;
5        long typeB = 6;
6        for (int i = 2; i <= n; i++) {
7            long newA = (2 * typeA + 2 * typeB) % MOD;
8            long newB = (2 * typeA + 3 * typeB) % MOD;
9            typeA = newA;
10            typeB = newB;
11        }
12        return (int) ((typeA + typeB) % MOD);
13    }
14}