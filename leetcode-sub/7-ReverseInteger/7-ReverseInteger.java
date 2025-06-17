// Last updated: 6/16/2025, 8:05:56 PM
class Solution {
    public int reverse(int x) {
        int n = Math.abs(x);
        long num = 0;
        while (n > 0) {
            int d = n % 10;
            num = 10 * num + d;
            n /= 10;
            if (num > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return x < 0 ? (int) -num : (int) num;
    }
}