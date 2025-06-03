// Last updated: 6/2/2025, 9:54:44 PM
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, min = nums[0], top = -1;
        if (n < 3) return false;
        int[][] stack = new int[n][2];
        for (int i = 1; i < n; i++) {
            while (top != -1 && stack[top][0] <= nums[i]) {
                top--;
            }
            if (top != -1 && nums[i] > stack[top][1]) {
                return true;
            }
            stack[++top][0] = nums[i];
            stack[top][1] = min;
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
