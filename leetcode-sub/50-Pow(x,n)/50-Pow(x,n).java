// Last updated: 6/23/2025, 2:57:21 PM
class Solution {
    public double myPow(double x, int n) {
        long a = n; // x^n = x^a
        if (a < 0) {
            x = 1 / x;
            a = -a;
        }
        double res = 1;
        while (a > 0) {
            if ((a & 1) == 1) { // a % 2 == 1, odd
                res *= x;
            } 
            x *= x;
            a >>= 1; // a /= 2, divide by 2
        }
        return res;
    }
}