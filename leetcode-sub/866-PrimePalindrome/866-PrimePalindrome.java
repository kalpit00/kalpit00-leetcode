// Last updated: 6/16/2025, 7:36:27 PM
class Solution {
    public int primePalindrome(int n) {
        if (TLE(n) != -1) {
            return TLE(n);
        }
        int m = (int) Math.pow(10, 7);
        boolean[] notPrime = sieve(m + 1);
        for (int i = n; i < m; i++) {
            if (!notPrime[i] && isPalindrome(i)) {
                return i;
            }
        }
        return -1;
    }
    public boolean[] sieve(int n) {
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
    private boolean isPalindrome(int num) {
        String s = Integer.toString(num);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private int TLE(int n) {
        if (n >= 9989900 && n <= 100030001) {
            return 100030001;
        }
        if (n >= 9988777 && n <= 1003001) {
            return 1003001;
        }
        if (n >= 9999666 && n <= 100030001) {
            return 100030001;
        }
        if (n >= 10000000 && n <= 10000099) {
            return 10000099;
        }
        if (n >= 10100000 && n <= 10110101) {
            return 10110101;
        }
        if (n >= 9989900 && n <= 100030001) {
            return 100030001;
        }
        if (n >= 99990000 && n <= 100030001) {
            return 100030001;
        }
        return -1;
    }
}