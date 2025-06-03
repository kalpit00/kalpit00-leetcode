// Last updated: 6/3/2025, 3:13:55 AM
class Solution {
    public int partitionArray(int[] nums, int k) {
        int count = 1, n = nums.length, prev = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) { 
            count += nums[i] - nums[prev] > k ? 1 : 0;
            prev = nums[i] - nums[prev] > k ? i : prev; 
        }
        return count;
    }
}