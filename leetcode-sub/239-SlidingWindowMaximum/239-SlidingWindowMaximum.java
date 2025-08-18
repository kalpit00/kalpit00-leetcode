// Last updated: 8/18/2025, 4:32:46 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1], pre = new int[n], suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = i % k == 0 ? nums[i] : Math.max(pre[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = i % k == 0 ? nums[i] : Math.max(suf[i + 1], nums[i]);
        }
        for (int i = 0; i <= n - k; i++) {
            res[i] = Math.max(suf[i], pre[i + k - 1]);
        }
        return res;
    }
}