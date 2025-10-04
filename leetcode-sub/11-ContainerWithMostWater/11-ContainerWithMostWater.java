// Last updated: 10/3/2025, 9:56:29 PM
class Solution {
    public int maxArea(int[] height) {
        int n = height.length, max = Integer.MIN_VALUE, i = 0, j = n - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            while (i < j && height[i] <= h) {
                i++;
            }
            while (i < j && height[j] <= h) {
                j--;
            }
        }
        return max;
    }
}