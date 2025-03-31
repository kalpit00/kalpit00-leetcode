// Last updated: 3/31/2025, 1:29:00 AM
class Solution {
    public int maximumLength(int[] nums) {
        int k = nums[0] % 2, odd = 0, even = 0, res = 0;
        for (int num : nums) { // count odd, even numbers
            even += num % 2 == 0 ? 1 : 0;
            odd += num % 2 == 1 ? 1 : 0;
            res += num % 2 == k ? 1 : 0;
            k = num % 2 == k ? 1 - k : k;
        } // toggle parity at each step
        return Math.max(res, Math.max(even, odd));
    }
}