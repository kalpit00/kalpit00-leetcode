// Last updated: 8/18/2025, 9:44:59 PM
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length, left = 0, right = 0, count = 0;
        long res = 0;
        while (right < n) {
            if (nums[right] != 0) {
                count++; // just count non-zero elements
            }
            right++;
            while (count != 0) {
                if (nums[left] != 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
}