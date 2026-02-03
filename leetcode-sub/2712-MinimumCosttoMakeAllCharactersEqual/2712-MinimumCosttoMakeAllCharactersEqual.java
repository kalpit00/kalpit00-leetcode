// Last updated: 2/3/2026, 12:13:29 AM
class Solution {
    public long minimumCost(String s) {
        int n = s.length();
        long cost = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                cost += Math.min(i, n - i);
            }
        }
        return cost;
    }
}
