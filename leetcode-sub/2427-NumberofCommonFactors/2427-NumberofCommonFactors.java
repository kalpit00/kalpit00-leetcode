// Last updated: 3/21/2025, 8:54:05 AM
class Solution {
    public int commonFactors(int a, int b) {
        int count = 0, min = Math.min(a, b);
        for (int i = 1; i <= min; i++) {
            count += a % i == 0 && b % i == 0 ? 1 : 0;
        }
        return count;
    }
}