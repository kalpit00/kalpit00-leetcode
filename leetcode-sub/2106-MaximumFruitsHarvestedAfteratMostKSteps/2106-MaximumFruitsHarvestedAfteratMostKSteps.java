// Last updated: 8/2/2025, 10:13:48 PM
class Solution {
        public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, n = fruits.length, max = 0, sum = 0;
        while (left < n && fruits[left][0] + k < startPos) {
            left++;
        }
        int right = left;
        while (right < n && startPos + k >= fruits[right][0]) {
            sum += fruits[right][1]; // <r - 2l + src, 2r - l - src
            while (Math.min(fruits[right][0] - 2 * fruits[left][0] + startPos,
            2 * fruits[right][0] - fruits[left][0] - startPos) > k) {
                sum -= fruits[left][1];
                left++;
            }
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
}
