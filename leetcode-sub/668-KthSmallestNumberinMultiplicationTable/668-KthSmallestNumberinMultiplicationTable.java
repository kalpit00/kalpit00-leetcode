// Last updated: 6/25/2025, 4:20:49 PM
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int start = 1, end = m * n, ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(mid, m, n, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public boolean helper(int mid, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(mid / i, n);
        }
        return count >= k;
    }
}