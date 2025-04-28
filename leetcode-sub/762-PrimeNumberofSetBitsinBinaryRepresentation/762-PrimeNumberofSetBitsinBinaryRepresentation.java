// Last updated: 4/28/2025, 3:47:31 PM
class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] notPrime = sieve(33);
        int count = 0;
        for (int i = left; i <= right; i++) {
            count += isPrime(Integer.bitCount(i)) ? 1 : 0;
        }
        return count;
    }
    private boolean isPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
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