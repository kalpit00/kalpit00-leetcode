// Last updated: 4/24/2025, 9:12:57 PM
class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        long count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum = (sum + (num % mod == k ? 1 : 0)) % mod;
            count += map.getOrDefault((sum - k + mod) % mod, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}