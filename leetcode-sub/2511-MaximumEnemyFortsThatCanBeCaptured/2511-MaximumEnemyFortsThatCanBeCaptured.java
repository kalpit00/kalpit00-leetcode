// Last updated: 11/16/2025, 12:08:21 AM
class Solution {
    public int captureForts(int[] nums) {
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++) {
            int m = 1, left = -9, right = -9; // m = streak length
            left = i > 0 ? nums[i - 1] : -9;
            boolean flag = nums[i] == 0;
            while (i < n - 1 && nums[i] == 0 && nums[i] == nums[i + 1]) {
                i++;
                m++;
            }
            right = i < n - 1 ? nums[i + 1] : -9;
            max = left + right == 0 && flag ? Math.max(max, m) : max;
        }
        return max;
    }
}