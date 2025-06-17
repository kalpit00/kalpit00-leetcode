// Last updated: 6/16/2025, 8:11:09 PM
class Solution {
    public int primePalindrome(int n) {
        for (int i = n; i <= 200000000; i++) {
            i = i > 10000000 && i < 100000000 ? 100000000 : i;
            // no palindromes between [10000000, 100000000], move 'i' ahead
            if (i == reverse(i) && isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } 
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
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
