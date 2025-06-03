// Last updated: 6/2/2025, 9:55:56 PM
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, min = nums[0];
        if (n < 3) return false;
        Stack<int[]> stack = new Stack<>(); // <nums[i], pre[i]>
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] <= nums[i]) {
                stack.pop();
            }
            min = Math.min(min, nums[i]);
            if (!stack.isEmpty() && nums[i] > stack.peek()[1]) {
                return true;
            }
            stack.push(new int[]{nums[i], min});
        }
        return false;
    }
}
