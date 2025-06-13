// Last updated: 6/12/2025, 11:38:35 PM
class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length, start = 0, end = nums[n - 1] - nums[0], ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(nums, mid) >= p) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    private int helper(int[] nums, int mid) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= mid) {
                count++;
                i++;
            }
        }
        return count;
    }
}