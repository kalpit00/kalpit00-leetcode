// Last updated: 11/11/2025, 7:49:23 PM
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, count = 0, min = Integer.MAX_VALUE;
        for (int num : nums) {
            count += num == 1 ? 1 : 0;
        }
        if (count > 0) {
            return n - count;
        }
        for (int i = 0; i < n; i++) {
            int gcd = nums[i];
            for (int j = i + 1; j < n; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == 1) {
                    min = Math.min(min, j - i);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min + n - 1;
    }
    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
