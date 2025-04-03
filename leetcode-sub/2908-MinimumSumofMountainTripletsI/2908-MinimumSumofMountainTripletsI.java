// Last updated: 4/3/2025, 5:06:14 PM
class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        int[] pre = new int[n], suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.min(suf[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (pre[i - 1] < nums[i] && suf[i + 1] < nums[i]) {
                min = Math.min(min, pre[i - 1] + suf[i + 1] + nums[i]);
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }
}