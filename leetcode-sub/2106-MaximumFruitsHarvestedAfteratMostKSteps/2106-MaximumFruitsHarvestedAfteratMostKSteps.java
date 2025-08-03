// Last updated: 8/2/2025, 10:23:14 PM
class Solution {
        public int maxTotalFruits(int[][] fruits, int src, int k) {
        int left = 0, right = 0, n = fruits.length, max = 0, sum = 0;
        while (right < n) {
            sum += fruits[right][1];
            while (left < n && helper(fruits, src, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
    public int helper(int[][] fruits, int src, int left, int right) {
        int r = fruits[right][0], l = fruits[left][0];
        int k = r - l;
        int start = Math.min(Math.abs(src - r), Math.abs(src - l));
        return start + k;
    }
}
