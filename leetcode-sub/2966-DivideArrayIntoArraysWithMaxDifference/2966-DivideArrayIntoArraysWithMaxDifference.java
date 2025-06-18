// Last updated: 6/17/2025, 8:54:43 PM
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n / 3][3];
        for (int i = 0; i < n - 2; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}