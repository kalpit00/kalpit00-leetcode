// Last updated: 10/14/2025, 10:06:04 PM
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), max = 0;
        int[] pre = new int[n], suf = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(suf, 1);
        for (int i = 1; i < n; i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                pre[i] = pre[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) { 
                suf[i] = suf[i + 1] + 1;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, Math.min(pre[i], suf[i + 1]));
        }
        return max;
    }
}