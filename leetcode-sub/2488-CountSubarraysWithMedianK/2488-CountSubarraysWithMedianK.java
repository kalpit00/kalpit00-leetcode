// Last updated: 7/23/2025, 12:14:00 AM
class Solution {
    public int countSubarrays(int[] nums, int k) {
        int idx = 0, n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k){
                idx = i;
                break;
            }
        }
        Map<Integer, Integer> map = new HashMap<>(); 
        for (int i = idx; i < n; i++) {
            sum += nums[i] == k ? 0 : nums[i] > k ? 1 : -1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        long count = 0;
        sum = 0;
        for (int i = idx; i >= 0; --i){
            sum += nums[i] == k ? 0 : nums[i] > k ? 1 : -1;
            count += map.getOrDefault(0 - sum , 0);
            count += map.getOrDefault(1 - sum , 0);
        }
        return (int) count;
    }
}