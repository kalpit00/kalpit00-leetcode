// Last updated: 11/16/2025, 12:12:07 AM
class Solution {
    public int captureForts(int[] nums) {
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++) {
            int m = 1, left = i > 0 ? nums[i - 1] : -2;
            boolean flag = nums[i] == 0;
            while (i < n - 1 && nums[i] == 0 && nums[i] == nums[i + 1]) {
                i++;
                m++;
            }
            int right = i < n - 1 ? nums[i + 1] : -2;
            max = left + right == 0 && flag ? Math.max(max, m) : max;
        }
        return max;
    }
}