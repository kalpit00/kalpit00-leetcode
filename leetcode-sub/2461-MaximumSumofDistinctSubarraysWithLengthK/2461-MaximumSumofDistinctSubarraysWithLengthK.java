// Last updated: 10/19/2025, 9:17:24 AM
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length, count = 0;
        long sum = 0, max = 0;
        int[] map = new int[100001];
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map[nums[i]]++;
            count += map[nums[i]] > 1 ? 1 : 0;
        }
        max = count == 0 ? Math.max(max, sum) : max;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            map[nums[i - k]]--;
            count -= map[nums[i - k]] > 0 ? 1 : 0;
            map[nums[i]]++;
            count += map[nums[i]] > 1 ? 1 : 0;
            max = count == 0 ? Math.max(max, sum) : max;
        }
        return max;
    }
}