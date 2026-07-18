// Last updated: 7/18/2026, 3:00:33 PM
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int[] prefix_sum = new int[2*nums.length+1];
        prefix_sum[nums.length] = 1;
        int cnt = nums.length;
        int presum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                presum += prefix_sum[cnt];
                cnt += 1;
                prefix_sum[cnt] += 1;
            } else {
                cnt -= 1;
                presum -= prefix_sum[cnt];
                prefix_sum[cnt] += 1;
            }
            result += presum;

        }


        return result;
    }
}