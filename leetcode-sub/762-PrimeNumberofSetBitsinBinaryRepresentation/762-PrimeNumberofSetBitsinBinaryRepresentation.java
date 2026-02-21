// Last updated: 2/21/2026, 3:16:31 AM
1class Solution {
2    public int countPrimeSetBits(int left, int right) {
3        int count = 0;
4        for (int i = left; i <= right; i++) {
5            count += isPrime(Integer.bitCount(i)) ? 1 : 0;
6        }
7        return count;
8    }
9    private boolean isPrime(int x) {
10        return (x == 2 || x == 3 || x == 5 || x == 7 ||
11                x == 11 || x == 13 || x == 17 || x == 19);
12    }
13}