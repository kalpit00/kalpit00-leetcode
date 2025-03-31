// Last updated: 3/30/2025, 8:37:39 PM
class Solution {
    public long putMarbles(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int[] map = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            map[i] = nums[i] + nums[i + 1];
        }
        Arrays.sort(map);
        for (int i = 0; i < k - 1; i++) {
            sum += map[n - i - 2] - map[i];
        }
        return sum;
    }
}