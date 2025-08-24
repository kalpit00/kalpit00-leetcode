// Last updated: 8/24/2025, 5:33:51 PM
class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        int n = nums.length, mod = 1000000007;
        long[] map = new long[n]; // map[i] = 2^i % mod
        map[0] = 1; // 2^0 = 1
        for (int i = 1; i < n; i++) {
            map[i] = (map[i - 1] * 2) % mod;
        }
        for (int i = 0; i < n; i++) {
            sum += nums[i] * map[i]; // + 2^i 
            sum -= nums[i] * map[n - i - 1]; // - 2^(n - i - 1)
            sum %= mod;
        }
        return (int) sum;
    }
}