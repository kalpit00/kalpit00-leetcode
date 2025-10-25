// Last updated: 10/24/2025, 10:27:44 PM
class Solution {
    public int totalMoney(int n) {
        int m = n / 7, k = n % 7;
        return ap(28, 7, m) + ap(m + 1, 1, k);
    }
    private int ap(int a, int d, int n) {
        return n * (2*a + (n - 1) * d) / 2;
    }
}