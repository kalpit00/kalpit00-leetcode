// Last updated: 6/3/2025, 12:37:18 AM
class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length, mod = (int) 1e9 + 7, count = 0;
        for (int i = 0; i < n; i++) {
            int diff = nums[i] - rev(nums[i]);
            count = (count + map.getOrDefault(diff, 0)) % mod;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return count;
    }
    private int rev(int num) {
        int res = 0;
        while (num > 0) {
            int d = num % 10;
            res = res * 10 + d;
            num /= 10;
        }
        return res;
    }
}