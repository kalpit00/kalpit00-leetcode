// Last updated: 5/31/2025, 8:20:26 PM
class Solution {
    public long distributeCandies(int n, int limit) {
        long count = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            count += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return count;
    }
}