// Last updated: 9/27/2025, 6:05:52 PM
class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] nums = new int[time + 1];
        int n = nums.length;
        for (int[] clip : clips) {
            int start = clip[0], end = clip[1];
            if (start < n) {
                nums[start] = Math.max(nums[start], end - start);
            }
        }
        return jump(nums);
    }
    public int jump(int[] nums) {
        int end = 0, reach = 0, jumps = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (reach < i) {
                return -1;
            }
            reach = Math.max(reach, i + nums[i]);
            if (i == end) {
                end = reach;
                jumps += i != n - 1 ? 1 : 0;
            }
        }
        return jumps;
    }
}