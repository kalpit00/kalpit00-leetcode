// Last updated: 10/14/2025, 6:42:15 AM
class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n], suf = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(suf, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] >= nums[i]) { // decreasing left to right
                pre[i] = pre[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) { // increasing left to right
            if (nums[i] <= nums[i + 1]) { 
                suf[i] = suf[i + 1] + 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (pre[i - 1] >= k && suf[i + 1] >= k) {
                res.add(i);
            }
        }
        return res;
    }
}