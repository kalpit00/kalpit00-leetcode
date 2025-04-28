// Last updated: 4/28/2025, 4:42:52 AM
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int left = 0, right = 0, n = nums.length;
        long count = 0, sum = 0;
        while (right < n) {
            sum += nums[right]; // running Sum
            right++;
            // score = sum * len of subarr
            while (sum * (right - left) >= k) {
                sum -= nums[left];
                left++;
            }
            count += right - left;
        }
        return count;
    }
}