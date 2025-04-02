// Last updated: 4/1/2025, 9:54:49 PM
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        int[] pre = new int[n], suf = new int[n];
        pre[0] = nums[0]; // or use int_max
        suf[n - 1] = nums[n - 1]; // use int_min
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], nums[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, (long) (pre[i - 1] - nums[i]) * suf[i + 1]);
        }
        return res;
    }
}