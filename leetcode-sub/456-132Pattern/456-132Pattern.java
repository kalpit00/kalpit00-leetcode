// Last updated: 6/2/2025, 10:22:27 PM
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, top = -1;
        if (n < 3) return false;
        int[][] stack = new int[n][2]; // <i, pre[i]>
        int[] NGE = new int[n];
        Arrays.fill(NGE, n);
        for (int i = 0; i < n; i++) {
            while (top != -1 && nums[stack[top][0]] <= nums[i]) {
                int t = stack[top][0];
                NGE[t] = i; // its redundant, we don't need NGE[]
                top--;
            }
            if (top != -1 && nums[i] > stack[top][1]) {
                return true;
            }
            stack[++top][0] = i;
            stack[top][1] = min;
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
