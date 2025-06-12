// Last updated: 6/11/2025, 8:00:57 PM
class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0, n = nums.length, pre = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            if (pre == sum) {
                return i;
            }
            pre += nums[i];
        }
        return -1;
    }
}