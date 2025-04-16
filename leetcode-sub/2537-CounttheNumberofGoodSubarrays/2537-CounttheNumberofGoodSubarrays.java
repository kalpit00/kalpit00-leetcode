// Last updated: 4/15/2025, 10:55:52 PM
class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length, left = 0, right = 0;
        long count = 0, total = (long) n * (n + 1)/2;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            k -= map.getOrDefault(nums[right], 0);
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            right++;
            while (k <= 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                k += map.get(nums[left]);
                left++;
            }
            count += right - left;
        }
        return total - count;
    }
}