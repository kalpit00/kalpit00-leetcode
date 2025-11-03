// Last updated: 11/2/2025, 9:31:06 PM
class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] s = colors.toCharArray();
        int sum = 0, max = neededTime[0], n = s.length;
        for (int i = 1; i < n; ++i) {
            max = s[i] != s[i - 1] ? 0 : max;
            sum += Math.min(neededTime[i], max);
            max = Math.max(max, neededTime[i]);
        }
        return sum;
    }
}