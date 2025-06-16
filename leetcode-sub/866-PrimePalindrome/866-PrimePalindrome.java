// Last updated: 6/16/2025, 7:54:36 PM
class Solution {
    public int primePalindrome(int n) {
        while (true) {
            if (n == reverse(n) && isPrime(n)) {
                return n;
            }
            n++;
            if (10000000 < n && n < 100000000) {
                n = 100000000;
            } // Any even length palindrome must be divisble by 11
        } // so we will skip numbers N = [10,000,000, 99,999,999]
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) {
                return false;
            } 
        return true;
    }

    public int reverse(int n) {
        int num = 0;
        while (n > 0) {
            int d = n % 10;
            num = 10 * num + d;
            n /= 10;
        }
        return num;
    }
}
