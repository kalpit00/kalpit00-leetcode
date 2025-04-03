// Last updated: 4/2/2025, 9:34:48 PM
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        int[] pre = new int[n], suf = new int[n];
        pre[0] = nums[0];
        suf[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
            suf[n - i - 1] = Math.max(suf[n - i], nums[n - i - 1]);
        } // can just combine pre[] and suf[] passes into one!
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, (long) (pre[i - 1] - nums[i]) * suf[i + 1]);
        }
        return res;
    }
}