// Last updated: 7/27/2025, 8:28:08 PM
class Solution {
    int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length, max = 0;
        for (int num : nums) {
            max |= num;
        }
        solve(0, n, nums, 0, max);
        return count;
    }
    private void solve(int i, int n, int[] nums, int xOr, int max) {
        if (i >= n) {
            count += xOr == max ? 1 : 0;
            return;
        }
        solve(i + 1, n, nums, xOr | nums[i], max);
        solve(i + 1, n, nums, xOr, max);
    }
}