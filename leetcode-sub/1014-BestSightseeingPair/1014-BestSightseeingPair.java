// Last updated: 6/15/2025, 8:45:43 PM
class Solution {
    public int maxScoreSightseeingPair(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        int[] pre = new int[n], suf = new int[n];
        pre[0] = nums[0] + 0; // nums[i] + i, plug i = 0
        suf[n - 1] = nums[n - 1] - (n - 1); // nums[i] - i, plug i = n - 1
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i] + i);
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], nums[i] - i);
        }
        for (int i = 1; i < n; i++) {
            max = Math.max(max, pre[i - 1] + suf[i]);
        }
        return max;
    }
}
