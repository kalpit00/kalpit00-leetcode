// Last updated: 4/28/2025, 3:46:17 PM
class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] notPrime = sieve(33);
        int count = 0;
        for (int i = left; i <= right; i++) {
            count += !notPrime[Integer.bitCount(i)] ? 1 : 0;
        }
        return count;
    }
    private boolean[] sieve(int n) {
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return notPrime;
    }
}