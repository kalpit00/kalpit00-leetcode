// Last updated: 4/12/2025, 8:04:05 PM
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length, idx = 1, max = 1, prev = nums[0];
        if (n < 2) {
            return n;
        }
        while (idx < n && nums[idx - 1] == nums[idx]) {
            idx++;
        }
        if (idx == n) {
            return 1;
        }
        boolean flag = nums[idx] > nums[0];
        for (int i = idx; i < n; i++) {
            if ((flag && nums[i] > prev) || (!flag && nums[i] < prev)) {
                flag = !flag;
                max++;
            }
            prev = nums[i];
        }
        return max;
    }
}