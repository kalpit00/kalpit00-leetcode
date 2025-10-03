// Last updated: 10/3/2025, 5:48:26 PM
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length, max = 0, min = Integer.MAX_VALUE;
        int[] pre0 = new int[n + 1], pre1 = new int[n + 1], 
        arr = new int[n + 1];
        Integer[] map = new Integer[200002];
        for (int i = 1; i <= n; i++) {
            pre0[i] = pre0[i - 1] + (nums[i - 1] == 0 ? 1 : 0);
            pre1[i] = pre1[i - 1] + (nums[i - 1] == 1 ? 1 : 0);
            arr[i] = pre0[i] - pre1[i];            
            min = Math.min(min, arr[i]);
        }
        min = min >= 0 ? 0 : min;
        for (int i = 0; i <= n; i++) {
            int idx = arr[i] - min;
            map[idx] = map[idx] == null ? i : map[idx];
            max = Math.max(max, i - map[idx]);
        }
        return max;
    }
}