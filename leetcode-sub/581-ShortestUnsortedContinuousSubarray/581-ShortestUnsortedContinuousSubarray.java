// Last updated: 7/19/2025, 10:10:05 PM
class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length, pre = 0, sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n - 1; i++) {
            pre += nums[i];
            sum -= nums[i];
            count += (pre - sum) % 2 == 0 ? 1 : 0;
        }
        return count;
    }
}