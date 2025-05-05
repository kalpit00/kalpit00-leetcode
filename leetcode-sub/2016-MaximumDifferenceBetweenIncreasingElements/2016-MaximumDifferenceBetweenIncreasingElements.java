// Last updated: 5/5/2025, 6:07:46 PM
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length, max = -1;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], nums[i]);
        }
        for (int i = 1; i < n; i++) {
            if (pre[i - 1] < nums[i]) {
                max = Math.max(max, nums[i] - pre[i - 1]);
            }
        }
        return max;
    }
}